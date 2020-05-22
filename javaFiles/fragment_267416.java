@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
  Address address;
  String name;

  // annotate with XmlTransient to prevent mapping this property/type to XML
  @XmlTransient
  String ssn;
  ...
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
  String planet;
  ...
}