package forum10109418;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Details {

   private List<Picture> pictures;

   @XmlElementWrapper
   @XmlElement(name="picture")
   public List<Picture> getPictures() {
      return this.pictures;
   }

   public void setPictures( List<Picture> pictures ) {
      this.pictures = pictures;
   }

}