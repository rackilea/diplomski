@XmlRootElement      
public class Person {
  @XmlElement(name = "name")
  private String name;

  @XmlElement(name = "age")
  private int age;

  @XmlElement(name = "someAttribute2")
  private Map<String, String> someAttributeTwo;

  @XmlElement(name = "someAttribute1")
  private Map<String, String> someAttributeOne;
}