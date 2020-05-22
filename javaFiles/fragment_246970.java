import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;

import org.apache.poi.xssf.model.SharedStringsTable;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;

import javax.xml.namespace.QName;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Iterator;

class StaxReplaceInlineStrings {

 public static void main(String[] args) {
  try {

   File file = new File("TestInlineStrings.xlsx");
   OPCPackage opcpackage = OPCPackage.open(file);

   //if there are strings in the sheet data, we need the SharedStringsTable
   PackagePart sharedstringstablepart = opcpackage.getPartsByName(Pattern.compile("/xl/sharedStrings.xml")).get(0);
   SharedStringsTable sharedstringstable = new SharedStringsTable();
   sharedstringstable.readFrom(sharedstringstablepart.getInputStream());

   PackagePart sheetpart = opcpackage.getPartsByName(Pattern.compile("/xl/worksheets/sheet1.xml")).get(0);

   XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(sheetpart.getInputStream());
   XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(sheetpart.getOutputStream());

   XMLEventFactory eventFactory = XMLEventFactory.newInstance();


   while(reader.hasNext()){ //loop over all XML in sheet1.xml

    boolean cellReplaced = false; //marker whether cell having inline string was replaced by cell having shared string

    XMLEvent event = (XMLEvent)reader.next();
    if(event.isStartElement()){
     StartElement startElement = (StartElement)event;
     QName startElementName = startElement.getName();
     if (startElementName.getLocalPart().equalsIgnoreCase("c")) { //start element of cell
      Attribute attribute;
      StartElement cellStart = startElement; //remember cell start
      Iterator attributeIterator = cellStart.getAttributes(); //get cell's attributes
      while (attributeIterator.hasNext()) {
       attribute = (Attribute)attributeIterator.next();
       if ("t".equals(attribute.getName().getLocalPart())) { //cell has type attribute
        String tvalue = attribute.getValue();
        if ("inlineStr".equals(tvalue)) { //cell type is inline string
         String inlineString = "";
         startElement = (StartElement)(XMLEvent)reader.next(); //read next start element - error if is not a start element
         startElementName = startElement.getName();
         if (startElementName.getLocalPart().equalsIgnoreCase("is")) { //start element of inline string     
          startElement = (StartElement)(XMLEvent)reader.next(); //read next start element - error if is not a start element
          startElementName = startElement.getName();
          if (startElementName.getLocalPart().equalsIgnoreCase("t")) { //start element of text
           Characters characters = (Characters)(XMLEvent)reader.next(); //read next characters element - error if is not a characters element   
           inlineString = characters.getData(); //get text data  
System.out.println(inlineString); 
          }
         }

         //create shared string in shared strings table
         CTRst ctstr = CTRst.Factory.newInstance();
         ctstr.setT(inlineString);
         int sRef = sharedstringstable.addEntry(ctstr);

         //we are replacing the cell element so skip elements until end element of cell
         while(reader.hasNext()) {
          event = (XMLEvent)reader.next();
          if(event.isEndElement()){
           EndElement endElement = (EndElement)event;
           QName endElementName = endElement.getName();
           if (endElementName.getLocalPart().equalsIgnoreCase("c")) { //end element of cell 
            break;
           }
          }
         }

         //create the new cell element having the shared string
         Attribute r = cellStart.getAttributeByName(new QName("r"));
         Attribute s = cellStart.getAttributeByName(new QName("s"));
         Attribute t = eventFactory.createAttribute("t", "s");
         List attributeList = Arrays.asList(new Attribute[]{t});
         if (r != null && s != null) {
          attributeList = Arrays.asList(new Attribute[]{r, s, t});
         } else if (r != null) {
          attributeList = Arrays.asList(new Attribute[]{r, t});
         } else if (s != null) {
          attributeList = Arrays.asList(new Attribute[]{s, t});
         }
System.out.println(attributeList);
         StartElement newCellStart = eventFactory.createStartElement(new QName("c"), attributeList.iterator(), null);
         writer.add(newCellStart);
         StartElement newCellValue = eventFactory.createStartElement(new QName("v"), null, null);
         writer.add(newCellValue);
         Characters value = eventFactory.createCharacters(Integer.toString(sRef));
         writer.add(value);         
         EndElement newCellValueEnd = eventFactory.createEndElement(new QName("v"), null);
         writer.add(newCellValueEnd);
         EndElement newCellEnd = eventFactory.createEndElement(new QName("c"), null);
         writer.add(newCellEnd);

         cellReplaced = true; // mark that cell was replaced
         break;
        }
       } 
      }
     }
    }
    if (!cellReplaced) {
     writer.add(event); //by default write each read event, except cell was replaced
    }
   }
   writer.flush();

   //write the SharedStringsTable
   OutputStream out = sharedstringstablepart.getOutputStream();
   sharedstringstable.writeTo(out);
   out.close();

   opcpackage.close();

  } catch (Exception ex) {
     ex.printStackTrace();
  }
 }
}