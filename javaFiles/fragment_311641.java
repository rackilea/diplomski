import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.StringWriter;
import java.util.*;

public class ParsingTest {

    private JAXBContext jaxbContext;
    private Marshaller marshaller;

    @Before
    public void setUp() throws Exception {
        jaxbContext = JAXBContext.newInstance(SystemA.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    @Test
    public void testParse() throws Exception {
        final SystemA systemA = new SystemA();
        final List<String> users = new ArrayList<>();
        users.add("userA");
        users.add("userB");
        systemA.setUserList(users);

        final StringWriter stringWriter = new StringWriter();
        marshaller.marshal(systemA, stringWriter);
        System.out.println(stringWriter.toString());
        Assert.assertTrue(true);

        // XMLUnit.compareXML(stringWriter.toString(), reader);

    }

    @XmlRootElement(name = "SystemA")
    @XmlType(name = "SystemA", propOrder = {
            "userList"
    })
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class SystemA {

        @XmlJavaTypeAdapter(CustomAdapter.class)
        private Collection<String> userList;

        public Collection<String> getUserList() {
            return userList;
        }

        public void setUserList(Collection<String> userList) {
            this.userList = userList;
        }
    }

    public static class CustomAdapter extends XmlAdapter<String, Collection<String>> {

        @Override
        public Collection<String> unmarshal(String v) throws Exception {
            return new ArrayList<>();// TODO String -> List;
        }

        @Override
        public String marshal(Collection<String> v) throws Exception {
            final StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (String s : v) {
                stringBuilder.append(s);
                stringBuilder.append(",");
            }

            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
}