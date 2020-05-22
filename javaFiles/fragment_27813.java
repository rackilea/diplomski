@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
class Root {

    @XmlElement(name = "parent-element")
    @XmlJavaTypeAdapter(IdsXmlAdapter.class)
    private MultiItemList list;

    // getters, setters, toString
}

class MultiItemList {

    private List<String> ids;

    // getters, setters, toString
}