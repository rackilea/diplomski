import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class B {
    @XmlElement public String C; // sloppy, probably should be type Integer or something
    @XmlElement public String D;
    @XmlElement public String E;
}

// then, somewhere else in your code you want to serialize...
B b = new B();
b.C = "11";
b.D = "21";
b.E = "31";

JAXBContext c = JAXBContext.newInstance(B.class);

// where w is a Writer instance
c.createMarshaller().marshal(b, w);