import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XmlParent")
public class FooBar {

    private String name;
    private String qux;

    @XmlElement
    public String getName() {
        return name; 
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getQux() {
        return qux;
    }

    public void setQux(String qux) {
        this.qux = qux;
    }
}