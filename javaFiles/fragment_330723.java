@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "someNameWrapper", propOrder = {
        "one",
        "two"
})
public class MyClassWrapper {
    public MyClassWrapper() {}
    public MyClassWrapper(MyClass base) {
        this.base = base;
    }
    @XmlElement
    public getOne() { return base.getOne(); }
    @XmlElement
    public getTwo() { return base.getTwo(); }
}