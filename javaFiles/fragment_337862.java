@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "value")

    public class Value {

        @XmlElementRefs({
            @XmlElementRef(name = "syntax", namespace = "http://kp.com/schema/", type = JAXBElement.class),
            @XmlElementRef(name = "nodeValue", namespace = "http://kp.com/schema/", type = NodeValue.class),
            @XmlElementRef(name = "name", namespace = "http://kp.com/schema/", type = JAXBElement.class)
        })
        @XmlMixed
        @XmlAnyElement(lax = true)
        protected List<Object> content;