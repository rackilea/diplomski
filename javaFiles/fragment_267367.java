@XmlRootElement
 public class Product {
      String name;      

      @XmlElement(name="sss")
      public void setName(String name) {
           this.name = name;
      }
}