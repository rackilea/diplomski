package org.example.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"foo","bar"})
@XmlRootElement(name = "root")
public class Root {

    @XmlElementRef(name = "foo", namespace = "http://www.example.org/schema", type = JAXBElement.class)
    protected JAXBElement<String> foo;
    @XmlElementRef(name = "bar", namespace = "http://www.example.org/schema", type = JAXBElement.class)
    protected JAXBElement<String> bar;

    public JAXBElement<String> getFoo() {
        return foo;
    }

    public void setFoo(JAXBElement<String> value) {
        this.foo = value;
    }

    public JAXBElement<String> getBar() {
        return bar;
    }

    public void setBar(JAXBElement<String> value) {
        this.bar = value;
    }

}