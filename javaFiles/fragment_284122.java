@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "any"
})
@XmlRootElement(name = "name")
public class Name {

    @XmlAnyElement(lax = true)
    protected Object any;