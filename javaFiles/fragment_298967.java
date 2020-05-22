@XmlRootElement(name = "YourXMLRootElement") //name is not required if it class name is the same as YourXMLRootElement which I'm assuming is location
@XmlAccessorType(XmlAccessType.FIELD)
public class MyObject{
  public MyObject(){
  /**
    *JAXB requires empty constructor
    */
  }

  @XmlAttribute(name = "deductible")//name is not required if same as attribute name
  private String deductible;
  //getter and setter


  //other attributes with getters and setters
}