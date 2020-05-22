import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.BuiltinFormats;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.SAXHelper;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


public class ExampleEventUserModel {
 public void processOneSheet(String filename) throws Exception {
  OPCPackage pkg = OPCPackage.open(filename);
  XSSFReader r = new XSSFReader( pkg );
  SharedStringsTable sst = r.getSharedStringsTable();

  StylesTable st = r.getStylesTable();
  XMLReader parser = fetchSheetParser(sst, st);

  // To look up the Sheet Name / Sheet Order / rID,
  //  you need to process the core Workbook stream.
  // Normally it's of the form rId# or rSheet#
  InputStream sheet2 = r.getSheet("rId2");
  InputSource sheetSource = new InputSource(sheet2);
  parser.parse(sheetSource);
  sheet2.close();
 }

 public void processAllSheets(String filename) throws Exception {
  OPCPackage pkg = OPCPackage.open(filename);
  XSSFReader r = new XSSFReader( pkg );
  SharedStringsTable sst = r.getSharedStringsTable();

  StylesTable st = r.getStylesTable();
  XMLReader parser = fetchSheetParser(sst, st);

  Iterator<InputStream> sheets = r.getSheetsData();
  while(sheets.hasNext()) {
   System.out.println("Processing new sheet:\n");
   InputStream sheet = sheets.next();
   InputSource sheetSource = new InputSource(sheet);
   parser.parse(sheetSource);
   sheet.close();
   System.out.println("");
  }
 }

 public XMLReader fetchSheetParser(SharedStringsTable sst, StylesTable st) throws SAXException, ParserConfigurationException {
/*
  XMLReader parser =
  XMLReaderFactory.createXMLReader(
       "org.apache.xerces.parsers.SAXParser"
  );
*/
  XMLReader parser = SAXHelper.newXMLReader();
  ContentHandler handler = new SheetHandler(sst, st);
  parser.setContentHandler(handler);
  return parser;
 }


 /** 
  * See org.xml.sax.helpers.DefaultHandler javadocs 
  */
 private static class SheetHandler extends DefaultHandler {
  private SharedStringsTable sst;
  private StylesTable st;
  private String lastContents;
  private boolean nextIsString;
  private boolean nextIsStyledNumeric;
  private boolean inlineStr;
  private int styleIndex;
  private DataFormatter formatter;

  private int rowNumber;

  private SheetHandler(SharedStringsTable sst, StylesTable st) {
   this.sst = sst;
   this.st = st;
   this.rowNumber = 0;
   this.formatter = new DataFormatter(java.util.Locale.US, true);
   this.styleIndex = 0;
  }

  public void startElement(String uri, String localName, String name,
            Attributes attributes) throws SAXException {

   // row => row
   if(name.equals("row")) {
    if (attributes.getValue("r") != null) {
     rowNumber = Integer.valueOf(attributes.getValue("r"));
    } else {
     rowNumber++;
    }
    System.out.println("row: " + rowNumber);
   }

   if (rowNumber > 6) {

    // c => cell
    if(name.equals("c")) {
     // Print the cell reference
     System.out.print(attributes.getValue("r") + " - ");

     String cellType = attributes.getValue("t");

     // Figure out if the value is an index in the SST
     nextIsString = false;
     if(cellType != null && cellType.equals("s")) {
      nextIsString = true;
     } 

     // Figure out if the value is an inline string     
     inlineStr = false;
     if(cellType != null && cellType.equals("inlineStr")) {
      inlineStr = true;
     } 

     // Figure out if the value is an styled numeric value or date
     nextIsStyledNumeric = false;
     if(cellType != null && cellType.equals("n") || cellType == null) {
      String cellStyle = attributes.getValue("s");
      if (cellStyle != null) {
       styleIndex = Integer.parseInt(cellStyle);
       nextIsStyledNumeric = true;
      }
     } 
    }
   }

   // Clear contents cache
   lastContents = "";
  }

  public void endElement(String uri, String localName, String name)
            throws SAXException {
   if (rowNumber > 6) {

    // Process the last contents as required.
    // Do now, as characters() may be called more than once

    // If the value is in the shared string table, get it
    if(nextIsString) {
     int idx = Integer.parseInt(lastContents);
     lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
     nextIsString = false;
    }

    // v => contents of a cell
    // Output after we've seen the string contents
    if(name.equals("v") || (inlineStr && name.equals("c"))) {
     // If the value is styled numeric, use DataFormatter to formaat it
     if (nextIsStyledNumeric) {
      XSSFCellStyle style = st.getStyleAt(styleIndex);
      int formatIndex = style.getDataFormat();
      String formatString = style.getDataFormatString();
      if (formatString == null) {
       // formatString could not be found, so it must be a builtin format.
       formatString = BuiltinFormats.getBuiltinFormat(formatIndex);
      }
      double value = Double.valueOf(lastContents);
      lastContents = formatter.formatRawCellContents(value, formatIndex, formatString);
      nextIsStyledNumeric = false;
     } 
     // Print out the contents
     System.out.println(lastContents);
    }
   }
  }

  public void characters(char[] ch, int start, int length)
            throws SAXException {
   //collect each character part to the content
   lastContents += new String(ch, start, length);
  }
 }

 public static void main(String[] args) throws Exception {
  ExampleEventUserModel example = new ExampleEventUserModel();
  //example.processOneSheet(args[0]);
  example.processAllSheets(args[0]);
 }
}