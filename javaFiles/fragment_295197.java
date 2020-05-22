import javax.xml.bind.annotation.XmlSeeAlso;
import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

@XmlDiscriminatorNode("@type")
@XmlSeeAlso({Tank.class, Sedan.class})
class Vehicle {}