package forum10109418;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Details {

   private List<Picture> pictures;

   @XmlElementWrapper
   @XmlElements({
       @XmlElement( name="picture1", type=Picture.class ),
       @XmlElement( name="picture2", type=Picture.class ),
       @XmlElement( name="picture3", type=Picture.class ),
       @XmlElement( name="picture4", type=Picture.class ),
       @XmlElement( name="picture5", type=Picture.class ),
       @XmlElement( name="picture6", type=Picture.class ),
       @XmlElement( name="picture7", type=Picture.class ),
       @XmlElement( name="picture8", type=Picture.class ),
       @XmlElement( name="picture9", type=Picture.class ),
       @XmlElement( name="picture10", type=Picture.class ),
       @XmlElement( name="picture11", type=Picture.class ),
       @XmlElement( name="picture12", type=Picture.class ),
       @XmlElement( name="picture13", type=Picture.class ),
       @XmlElement( name="picture14", type=Picture.class ),
       @XmlElement( name="picture15", type=Picture.class ),
       @XmlElement( name="picture16", type=Picture.class ),
       @XmlElement( name="picture17", type=Picture.class ),
       @XmlElement( name="picture18", type=Picture.class ),
       @XmlElement( name="picture19", type=Picture.class ),
       @XmlElement( name="picture20", type=Picture.class ),
       @XmlElement( name="picture21", type=Picture.class ),
       @XmlElement( name="picture22", type=Picture.class ),
       @XmlElement( name="picture23", type=Picture.class ),
       @XmlElement( name="picture24", type=Picture.class ),
       @XmlElement( name="picture25", type=Picture.class ),
       @XmlElement( name="picture26", type=Picture.class ),
       @XmlElement( name="picture27", type=Picture.class ),
       @XmlElement( name="picture28", type=Picture.class ),
       @XmlElement( name="picture29", type=Picture.class ),
       @XmlElement( name="picture30", type=Picture.class )
   })

   public List<Picture> getPictures() {
      return this.pictures;
   }

   public void setPictures( List<Picture> pictures ) {
      this.pictures = pictures;
   }

}