@XmlRootElement(name="rss")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestXML {   
    public TestXML() {
    }

    @XmlElementWrapper(name="channel")
    @XmlElement(name="item")
    private int i ;

    public int getI() {
        return i;
    }    
    public void setI(int i) {
        this.i = i;
    }
}