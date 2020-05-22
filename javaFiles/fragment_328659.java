import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.w3c.dom.Node;

@XmlRootElement(name="Product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

  @XmlElement(name="CommonProperty")
  private String commonProperty="Something";  

  @XmlAnyElement
  private Node extraXml;

}