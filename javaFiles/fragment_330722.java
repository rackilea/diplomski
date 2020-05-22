// @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "someName"/*, propOrder = {
    "one",
    "two"
} */ )
// @XmlRootElement(name = "test")
@XmlAccessorType(XmlAccessType.NONE)
public class MyClass {
    // @XmlElement
    protected String one;
    // @XmlElement
    protected String two;
    ...

    // my own custom wrapper
    @XmlElement
    protected MyClassWrapper test = new MyClassWrapper(this);
}