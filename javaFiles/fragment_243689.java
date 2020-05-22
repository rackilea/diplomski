import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

@XmlRootElement
public class ClientAndTopicParameters
{

    @XmlElement public String                       client;
    @XmlElement public String                       forTopic;


    public static void main(String[] args) {

        try
        {
            boolean includeRoot = true;

            JAXBContext context = JAXBContext.newInstance     (ClientAndTopicParameters.class);
            Unmarshaller unmarshal = context.createUnmarshaller ();
            unmarshal.setProperty (UnmarshallerProperties.MEDIA_TYPE,     "application/json");
            unmarshal.setProperty (UnmarshallerProperties.JSON_INCLUDE_ROOT,     includeRoot);

            parseAndPrint(unmarshal, "{ \"client\": \"1\",  \"forTopic\": \"topic\"}");
            StringWriter sw = marshallDesiredObject(context, includeRoot);
            parseAndPrint(unmarshal, sw.toString());
        }
        catch (JAXBException e)
        {
            System.out.println("Unable to get Client and Topic parameters from POST.");
            e.printStackTrace();
        }
    }

    private static StringWriter marshallDesiredObject(JAXBContext context, boolean includeRoot)
        throws JAXBException, PropertyException {
        Marshaller marshal = context.createMarshaller ();

        marshal.setProperty (UnmarshallerProperties.MEDIA_TYPE, "application/json");
        marshal.setProperty (UnmarshallerProperties.JSON_INCLUDE_ROOT, includeRoot);

        ClientAndTopicParameters cp = new ClientAndTopicParameters();
        cp.client = "1";
        cp.forTopic = "topic";

        StringWriter sw = new StringWriter();
        marshal.marshal(cp, sw);
        return sw;
    }

    private static void parseAndPrint(Unmarshaller unmarshal, String requestBody)
            throws JAXBException {
        System.out.println("requestBody to parse: " + requestBody);
        ClientAndTopicParameters params = unmarshal.unmarshal(new StreamSource (new     StringReader (requestBody )), ClientAndTopicParameters.class).getValue ();
        System.out.println("params = " + params);
        System.out.println("client = " + params.client);
        System.out.println("forTopic = " + params.forTopic);
    }
}