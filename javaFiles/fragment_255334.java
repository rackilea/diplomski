package test.jaxb.one;

@XMLRootElement
@XMLType(name = "test.jaxb.one.SimpleObject")
@XMLAccessorType(XMLAccessType.FIELD)
public class SimpleObject implements Serializable {
    private static final long serialVersionUID = 54536613717262557148L;

    @XmlElement(name = "Name")
    private String name;

    // Constructor, Setters/Getters
}