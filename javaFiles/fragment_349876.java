package forum11698160;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Bobar extends Bar {

    @XmlElementRef
    public List<Thing> getThings() {
        return super.getThings();
    }

}