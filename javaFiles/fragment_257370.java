import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class A {
  @XmlPath("B/text()")
  @XmlElement(defaultValue="annotationDefault")
  private String b;

  @XmlPath("C/text()")
  @XmlElement(defaultValue="annotationDefault")
  private Integer c;

}