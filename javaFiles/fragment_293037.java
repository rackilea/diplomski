import javax.xml.bind.annotation;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@XmlAccessorType(XmlAccessType.FIELD)
public class B {
  @XmlInverseReference(mappedBy="refToB")
  A refToA;
}