@XmlRootElement(name = "mappings")
public class Mappings { 
    private List<Mapping> mMappings;

    @XmlElement(name="mapping")
    public List<Mapping> getMappings() {
        return mMappings;
    }

    public void setMappings(List<Mapping> aMappings) {
        this.mMappings = aMappings;
    }
}