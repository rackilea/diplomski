@XmlAccessorType(XmlAccessType.FIELD)
public class Foo implements Serializable {

    @XmlJavaTypeAdapter(CustomAdapter.class)
    private String someField;

    ...

 }