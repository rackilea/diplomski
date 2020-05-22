@XmlRootElement(name = "ns2:testase")
public class Testase {

    private String resource;
    private String units;

    public String getResource() {
        return resource;
    }

    @XmlAttribute(name = "ns7:resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getUnits() {
        return units;
    }

    @XmlAttribute(name = "units")
    public void setUnits(String units) {
        this.units = units;
    }
}