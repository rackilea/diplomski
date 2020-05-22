@XmlRootElement(name = "dataCase")
 @XmlAccessorType(XmlAccessType.FIELD)
 public class DataStorage {
     @XmlPath("data/@data1")
     private String data1;
     @XmlPath("data/@data2")
     private String data2;
     @XmlPath("data/@data3")
     private String data3;
 ....