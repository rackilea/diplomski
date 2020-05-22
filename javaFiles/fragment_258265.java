@XmlRootElement(name="bar")
public class Bar {

  @XmlElement
  @XmlJavaTypeAdapter(FooAdapter.class)
  private Foo foo;

  @XmlAttribute
  private String baz;

}