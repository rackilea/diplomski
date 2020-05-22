package forum8776746;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "request"
})
@XmlRootElement(name = "service")
public class Service {

    @XmlElement(required = true)
    protected Request request;

    public Request getRequest() {
        return request;
    }

   public void setRequest(Request value) {
        this.request = value;
    }

}