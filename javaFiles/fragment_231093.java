@XmlRootElement(name = "properties")
@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentProperty {

@XmlElement(name = "basic")
private Basic basic;

public Basic getBasic() {
    return basic;
}

public void setBasic(Basic basic) {
    this.basic = basic;
}

@Override
public String toString() {
    return "DocumentProperty{" +
            "basic=" + basic + "\n" +
            '}';
}
}