import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.sessions.SessionEventListener;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        SessionEventListener sessionEventListener = new NullPolicySessionEventListener();
        properties.put(JAXBContextProperties.SESSION_EVENT_LISTENER, sessionEventListener);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Address.class}, properties);

        Address address = new Address();

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(address, System.out);
    }

}