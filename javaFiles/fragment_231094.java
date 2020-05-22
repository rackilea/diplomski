@XmlRootElement(name = "basic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Basic {

@XmlElementRef
private List<Property> propertyList;

public List<Property> getPropertyList() {
    return propertyList;
}

public void setPropertyList(List<Property> propertyList) {
    this.propertyList = propertyList;
}

@Override
public String toString() {
    return "Basic{" +
            "propertyList=" + propertyList + "\n" +
            '}';
}
}