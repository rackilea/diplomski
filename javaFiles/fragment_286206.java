package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class ConsumerProfile {

    @XmlElement(name = "CONSUMER_DETAILS2")
    private ConsumerDetails CONSUMER_DETAILS2;

    @XmlElement(name = "ID_DETAILS2")
    private IdDetails ID_DETAILS2;

    public ConsumerProfile(){}

    public ConsumerDetails getCONSUMER_DETAILS2() {
        return CONSUMER_DETAILS2;
    }

    public void setCONSUMER_DETAILS2(ConsumerDetails cONSUMER_DETAILS2) {
        CONSUMER_DETAILS2 = cONSUMER_DETAILS2;
    }

    public IdDetails getID_DETAILS2() {
        return ID_DETAILS2;
    }

    public void setID_DETAILS2(IdDetails iD_DETAILS2) {
        ID_DETAILS2 = iD_DETAILS2;
    }
}