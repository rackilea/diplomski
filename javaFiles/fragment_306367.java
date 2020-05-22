package com.example;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() { }

    public Foo createFoo() { return new Foo(); }

    @XmlElementDecl(namespace="http://example.com",
            name="foo",
            substitutionHeadNamespace="http://www.opengis.net/gml",
            substitutionHeadName="_Feature")
    public JAXBElement<Foo> createFoo(Foo foo) {
        return new JAXBElement<Foo>(new QName("http://example.com", "foo"), Foo.class, foo);   
    }
}