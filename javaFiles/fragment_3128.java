package cars;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Brand {
  @XmlValue // i.e. the simple content of the <brand> element
  String name;

  // optional id and refId attributes (optional because they're
  // Integer rather than int)
  @XmlAttribute
  Integer id;

  @XmlAttribute
  Integer refId;
}