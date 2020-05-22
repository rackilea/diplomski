package xml.bus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Bus", namespace = "http://www.example.org/bus")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bus {
    @XmlElement(name = "Driver")
    Driver driver;
}