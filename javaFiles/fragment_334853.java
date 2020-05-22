@XmlRootElement
public class DTO {

    private HashMap<String, PropertyObject> properties;

    @XmlJavaTypeAdapter(PropertyAdapter.class)
    public HashMap<String, PropertyObject> getProperties() {
        return properties;
    }

    // setter
}