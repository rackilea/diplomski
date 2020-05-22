package test;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="myelem")
public class MyElem {

    private boolean required;

    @XmlAttribute
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean value) {
        required = value;
    }

}