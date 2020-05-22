package forum10520757;

import java.io.StringReader;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Person.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader xml = new StringReader("<person><id>QZhx_w1eEJ</id><first-name>pratap</first-name><last-name>murukutla</last-name></person>");
        Person person = (Person) unmarshaller.unmarshal(xml);

        System.out.println(person.id);
        System.out.println(person.firstName);
        System.out.println(person.lastName);
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Person {
        String id;

        @XmlElement(name="first-name")
        String firstName;

        @XmlElement(name="last-name")
        String lastName;
    }

}