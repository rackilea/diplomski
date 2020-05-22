...
@XmlRootElement(name = "person")
public class Person {

    @XmlElement(required = true)
    protected String firstname;
    @XmlElement(required = true)
    protected String lastname;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
...