package forum11340316;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder={"XThing"})
public class BarX extends Foo {

   @XmlElement(name="thing")
   public String getXThing() {
      return name;
   }

   public void setXThing(String thing) {
      name = thing;
   }

}