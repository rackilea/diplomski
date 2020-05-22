public class Parameter {
    private String mName;

     private String mValue;

    @XmlAttribute(name = "attr")
    public String getName() {
        return mName;
    }

    public void setName(String aName) {
        this.mName = aName;
    }

    @XmlValue
    public String getValue() {
        return mValue;
    }

    public void setValue(String aValue) {
        this.mValue = aValue;
    }
}