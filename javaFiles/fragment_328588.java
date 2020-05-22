package forum11340316;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder={"YBlah"})
public class BarY extends Foo {

   @XmlElement(name="blah")
   public String getYBlah() {
      return name;
   }

   public void setYBlah(String blah) {
      name = blah;
   }

}