@XmlAccessorType(XmlAccessType.FIELD)
public class Parameter {
    @XmlAttribute(name = "attr")
    private String mName;

    @XmlValue
    private String mValue;

    public String getName() {
        return mName;
    }

    public void setName(String aName) {
        this.mName = aName;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String aValue) {
        this.mValue = aValue;
    }
}