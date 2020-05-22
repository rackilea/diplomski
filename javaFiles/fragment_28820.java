@XmlRootElement(name="list")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListFoo {

    @XmlElement(name = "foo")
    private List<Foo> listFoo;

    // getters & setters

 }