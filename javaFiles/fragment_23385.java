package forum13952415;

import java.lang.reflect.Field;
import javax.xml.bind.*;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();

        setValueToObject(customer, "firstName", "Jane");
        setValueToObject(customer, "lastName", "Doe");

        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
    }

    private static void setValueToObject(Object object, String property, Object value) throws Exception {
        Class clazz = object.getClass();
        Field field = clazz.getDeclaredField(property);
        field.setAccessible(true);
        field.set(object, value);
    }

}