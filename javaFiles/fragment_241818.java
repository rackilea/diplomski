@XmlRootElement(name="claim")
public class Claim {
      @XmlElement(name="dta")
      List<Data> datas;
      //getter and setter
} 

public class Data {
  @XmlAttribute(name="type")
  String type;
  @XmlValue
  String description;
  //getter and setter 
}