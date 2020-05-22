@XmlRootElement(name = "property")
@XmlAccessorType(XmlAccessType.FIELD)
public class Property {

@XmlAttribute(name = "id")
private String id;

@XmlElement(name = "value")
private String value;

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getValue() {
    return value;
}

public void setValue(String value) {
    this.value = value;
}

@Override
public String toString() {
    return "Property{" +
            "id='" + id + "\n" +
            ", value='" + value + "\n" +
            '}';
}
}