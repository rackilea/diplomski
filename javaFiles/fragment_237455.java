@XmlRootElement(name = "element")
public class Element {
    private List<Element> children = new LinkedList<Element>();

    @XmlTransient
    public List<Element> getChildren() {
        return children;
    }

    @XmlElement(name = "element")
    public void setChild(Element child) {
        this.children.add(child);
    }

    private String value;

    @XmlAttribute
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}