import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;

private String getOuterXml(XMLStreamReader xmlr) throws TransformerConfigurationException,
    TransformerFactoryConfigurationError, TransformerException
{
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    StringWriter stringWriter = new StringWriter();
    transformer.transform(new StAXSource(xmlr), new StreamResult(stringWriter));
    return stringWriter.toString();
}