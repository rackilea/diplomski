public class Fields {

    @XmlElement(required = true)
    protected Summary summary;

    @XmlAnyElement
    private List<Element> fields;

    public List<Element> getFields() {
        return fields;
    }

    public Summary getSummary() {
        return summary;
    }
}