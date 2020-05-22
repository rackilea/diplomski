@XmlRootElement(name="thing")
public class Thing{

   @XmlPath("property[@key='name']/@value")
   public String name;
}