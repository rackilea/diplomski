import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

public class XMLConcat {
    public static void main(String[] args) throws Throwable {
        File dir = new File("/tmp/rootFiles");
        File[] rootFiles = dir.listFiles();

        Writer outputWriter = new FileWriter("/tmp/mergedFile.xml");
        XMLOutputFactory xmlOutFactory = XMLOutputFactory.newFactory();
        XMLEventWriter xmlEventWriter = xmlOutFactory.createXMLEventWriter(outputWriter);
        XMLEventFactory xmlEventFactory = XMLEventFactory.newFactory();

        xmlEventWriter.add(xmlEventFactory.createStartDocument());
        xmlEventWriter.add(xmlEventFactory.createStartElement("", null, "rootSet"));

        XMLInputFactory xmlInFactory = XMLInputFactory.newFactory();
        for (File rootFile : rootFiles) {
            XMLEventReader xmlEventReader = xmlInFactory.createXMLEventReader(new StreamSource(rootFile));
            XMLEvent event = xmlEventReader.nextEvent();
            // Skip ahead in the input to the opening document element
            while (event.getEventType() != XMLEvent.START_ELEMENT) {
                event = xmlEventReader.nextEvent();
            }

            do {
                xmlEventWriter.add(event);
                event = xmlEventReader.nextEvent();
            } while (event.getEventType() != XMLEvent.END_DOCUMENT);
            xmlEventReader.close();
        }

        xmlEventWriter.add(xmlEventFactory.createEndElement("", null, "rootSet"));
        xmlEventWriter.add(xmlEventFactory.createEndDocument());

        xmlEventWriter.close();
        outputWriter.close();
    }
}