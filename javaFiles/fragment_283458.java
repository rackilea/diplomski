package org.example.schema;

import javax.xml.bind.*;
import javax.xml.namespace.QName;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance("org.example.schema");

        Root root = new Root();

        QName fooQName = new QName("http://www.example.org/schema", "foo");
        JAXBElement<String> fooValue = new JAXBElement<String>(fooQName, String.class, "FOO");
        root.setFoo(fooValue);

        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<String> barValue = objectFactory.createRootBar("BAR");
        root.setBar(barValue);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(root, System.out);
    }

}