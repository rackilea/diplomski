package org.example.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _RootFoo_QNAME = new QName("http://www.example.org/schema", "foo");
    private final static QName _RootBar_QNAME = new QName("http://www.example.org/schema", "bar");

    public Root createRoot() {
        return new Root();
    }

    @XmlElementDecl(namespace = "http://www.example.org/schema", name = "foo", scope = Root.class)
    public JAXBElement<String> createRootFoo(String value) {
        return new JAXBElement<String>(_RootFoo_QNAME, String.class, Root.class, value);
    }

    @XmlElementDecl(namespace = "http://www.example.org/schema", name = "bar", scope = Root.class)
    public JAXBElement<String> createRootBar(String value) {
        return new JAXBElement<String>(_RootBar_QNAME, String.class, Root.class, value);
    }

}