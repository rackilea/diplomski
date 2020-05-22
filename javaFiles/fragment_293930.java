@XmlRootElement
public class Customer {
    @XmlElement
    @XmlJavaTypeAdapter(MapAdapter.class)
    public Map<String,String> addressMap;
}