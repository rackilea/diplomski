@XmlType(name="",propOrder={"test1","test2"})
@XmlRootElement(name="test")
public class Test
{
   @XmlElement(required=true)
   private String test1;
   @XmlElement(required=true)
   private String test2;
}