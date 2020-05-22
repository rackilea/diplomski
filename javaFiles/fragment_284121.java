@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "name")
public class Name {

    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<Object> content;