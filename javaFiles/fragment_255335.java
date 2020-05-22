package test.jaxb.two;

@XMLRootElement
@XMLType(name = "test.jaxb.two.SimpleObject")
@XMLAccessorType(XMLAccessType.FIELD)
public class SimpleObject implements Serializable {
    private static final long serialVersionUID = -4073071224211934153L;

    @XmlElement(name = "Name")
    private String name;

    // Constructor, Setters/Getters
}