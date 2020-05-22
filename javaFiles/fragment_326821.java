@XmlRootElement(name = "ns2:testpla")
public class Testpla {

    private Testase testase;

    public Testase getTestase() {
        return testase;
    }

    @XmlElement(name = "ns2:testase")
    public void setTestase(Testase testase) {
        this.testase = testase;
    }
}