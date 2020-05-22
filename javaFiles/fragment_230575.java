package org.mypackage.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BasicResponse {

    @XmlElementWrapper(name = "errors")
    @XmlElement(name = "message")
    private List<String> errors = new ArrayList<String>();

    public BasicResponse() {
        this.errors.add("test1");
        this.errors.add("test2");
    }

    public List<String> getErrors() {
        return errors;
    }

}