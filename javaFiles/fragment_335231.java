import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "custom-attribute")
@XmlAccessorType(XmlAccessType.PROPERTY)
class CustomAttribute {

  public List<Value> value;

  public List<Value> getValue() {
    return value;
  }

  public void setValue(List<Value> values) {
    this.value = values;
  }


}