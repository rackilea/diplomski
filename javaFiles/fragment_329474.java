import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.StringReader;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader("<customer id=\"100\"><age>29</age> <name>myname<b>abcd</b>123</name></customer>");
        Customer customer1 = (Customer) unmarshaller.unmarshal(reader);

        System.out.println(customer1);
    }
}

class TrimHtmlXmlAdapter extends XmlAdapter<Object, String> {

    @Override
    public String unmarshal(Object v) {
        Node node = (Node) v;
        StringBuilder builder = new StringBuilder();
        getNodeValueToString(node, builder);

        return builder.toString();
    }

    private void getNodeValueToString(Node node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        final String value = node.getNodeValue();
        if (value != null) {
            builder.append(value);
        }

        final NodeList childNodes = node.getChildNodes();
        final int size = childNodes.getLength();
        for (int i = 0; i < size; i++) {
            getNodeValueToString(childNodes.item(i), builder);
        }
    }

    @Override
    public Object marshal(String v) {
        return null;
    }
}


@XmlRootElement
class Customer {
    String name;
    int age;
    int id;

    public String getName() {
        return name;
    }

    @XmlElement
    @XmlJavaTypeAdapter(TrimHtmlXmlAdapter.class)
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}