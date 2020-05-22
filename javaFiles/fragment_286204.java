package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "DATAPACKET")
public class DataPacket {

    @XmlAttribute(name = "REQUEST_ID")
    private int REQUEST_ID;

    @XmlElement(name ="BODY")
    private Body BODY;

    public DataPacket(){}

    public int getREQUEST_ID() {
        return REQUEST_ID;
    }

    public void setREQUEST_ID(int REQUEST_ID) {
        this.REQUEST_ID = REQUEST_ID;
    }

    public Body getBODY() {
        return BODY;
    }

    public void setBODY(Body BODY) {
        this.BODY = BODY;
    }
}