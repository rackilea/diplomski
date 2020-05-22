public class AnyXmlElement {
    @XmlAnyAttribute
    private Map<QName, String> attributes;
    @XmlAnyElement
    private List<Object> elements;

    public AnyXmlElement() {
        attributes = new LinkedHashMap<QName, String>();
        elements = new ArrayList<Object>();
    }

    public void addAttribute(QName name, String value) {
        attributes.put(name, value);
    }

    public void addElement(Object element) {
        elements.add(element);
    }
}