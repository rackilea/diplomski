@XmlRootElement(name="root")
@XmlAccessorType( XmlAccessType.FIELD )
public class MyWrapper {

    @XmlElement(name="child")
    private List<MyClass> list = new ArrayList<MyClass>();

    public List<MyClass> getList() {
            return list;
    }
...