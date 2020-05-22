import java.io.StringReader;
import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.sessions.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextProperties.SESSION_EVENT_LISTENER, new SessionEventAdapter() {

            @Override
            public void postLogin(SessionEvent event) {
                Project project = event.getSession().getProject();
                for(ClassDescriptor descriptor : project.getOrderedDescriptors()) {
                    for(DatabaseMapping mapping : descriptor.getMappings()) {
                        mapping.setAttributeAccessor(new MyAttributeAccessor(mapping.getAttributeAccessor()));
                    }
                }
                super.preLogin(event);
            }

        });

        JAXBContext jc = JAXBContext.newInstance(new Class[] {Foo.class}, properties);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader xml = new StringReader("<foo><bar>Hello World</bar></foo>");
        Foo foo = (Foo) unmarshaller.unmarshal(xml);
    }

}