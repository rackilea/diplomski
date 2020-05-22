@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fruit")
@XmlSeeAlso({Apple.class, Banana.class})
public class Fruit{
 @XmlAttribute
 private String name;
 @XmlAttribute
 private String type;
}