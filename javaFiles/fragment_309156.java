package com.samnunnally;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "body"
})
@XmlRootElement(name = "xmlMessage")
public class XmlMessage {

    @XmlElement(required = true)
    protected Header header;
    @XmlElementRef(name = "body", namespace = "http://www.samnunnally.com", type = JAXBElement.class)
    protected JAXBElement<? extends Body> body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header value) {
        this.header = value;
    }

    public JAXBElement<? extends Body> getBody() {
        return body;
    }

    public void setBody(JAXBElement<? extends Body> value) {
        this.body = value;
    }
}