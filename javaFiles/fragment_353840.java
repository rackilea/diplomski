import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLStreamReaderDemo {

    public static void main(String[] args) throws Exception {
        String xmlFileName = "source.xml";
        StringBuilder javaSource = transform(xmlFileName);
        System.out.println(javaSource);
    }

    static StringBuilder transform(String xmlFileName) throws
            FactoryConfigurationError, IOException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;
        StringBuilder source = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(xmlFileName)) {
            parser = factory.createXMLStreamReader(inputStream);
            while (parser.hasNext()) {
                switch (parser.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        processStartElement(parser, source);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        processCharacters(parser, source);
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        processEndElement(parser, source);
                        break;
                    default:
                        break;
                }
                parser.next();
            }
        } finally {
            if (parser != null) {
                parser.close();
            }
        }
        return source;
    }

    static void processEndElement(XMLStreamReader reader, StringBuilder sb) {
        String element = reader.getLocalName();
        if ("class".equals(element)) {
            sb.append("}");
        } else if ("Attribut".equals(element)) {
            sb.append(";\n");
        }
    }

    static void processCharacters(XMLStreamReader reader, StringBuilder sb) {
        if (!reader.isWhiteSpace()) {
            sb.append(" ").append(reader.getText());
        }
    }

    static void processStartElement(XMLStreamReader reader, StringBuilder sb) {
        String element = reader.getLocalName();
        if ("class".equals(element)) {
            sb.append("public class ")
                    .append(reader.getAttributeValue(0))
                    .append(" {\n");
        } else if ("Attribut".equals(element)) {
            sb.append("    ")
                    .append(reader.getAttributeValue(0));
        }
    }
}