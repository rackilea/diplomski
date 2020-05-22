package forum13626828;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "element")
public class MyClass{

    protected String elementValue;

    @XmlValue
    public String getElementValue() {
        return elementValue;
    }

    public void setElementValue(String el) {
        this.elementValue = el;
    }

}