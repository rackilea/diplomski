@XmlRootElement
@XmlSeeAlso({Entity.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Entities{

    @XmlElement(name="entity")
    @XmlJavaTypeAdapter(YourAdapter.class)
    private Map<String,Object> yourMap;

    //getters, setters, and methods
}