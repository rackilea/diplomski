import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import java.io.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLOutputFactory xof = XMLOutputFactory.newFactory();

        try(
           FileInputStream in = new FileInputStream("in.xml");
           FileOutputStream out = new FileOutputStream("out.xml");
        ) {
            XMLEventReader xer = xif.createXMLEventReader(in);
            XMLEventWriter xew = xof.createXMLEventWriter(out);

            JAXBContext jc = JAXBContext.newInstance(File.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            while(xer.hasNext()) {
                if(xer.peek().isStartElement() && xer.peek().asStartElement().getName().getLocalPart().equals("file")) {
                    // Unmarshal the File object from the XMLEventReader
                    File file = (File) unmarshaller.unmarshal(xer);

                    // Modify the File object
                    file.description = "NEW DESCRIPTION";

                    // Marshal the File object to the XMLEventWriter
                    marshaller.marshal(file, xew);
                } else {
                    // Copy node from reader to writer
                    xew.add(xer.nextEvent());
                }
            }
        }
    }

}