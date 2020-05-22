import javax.xml.bind.annotation;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class A {
  @XmlElement(name="b")
  B refToB;
}