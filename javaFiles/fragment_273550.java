import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.*;

@XmlRootElement("OddEvenSettings")
@XmlAccessorType(XmlAccessType.FIELD)
public class OddEvenSettings {
  @XmlPath("odd/@setting1")
  int oddSetting1;

  @XmlPath("odd/@setting2")
  int oddSetting2;

  @XmlPath("even/@setting1")
  int evenSetting1;

  @XmlPath("even/@setting2")
  int evenSetting2;
}