import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class A {
  @XmlPath("B/text()")
  private String b = "fieldDefault";

  @XmlPath("C/text()")
  private Integer c;
}