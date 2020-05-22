import java.util.List;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.*;

@XmlRootElement
public class Fees {

    @XmlElements({
        @XmlElement(type=Commission.class),
        @XmlElement(type=FINRAPerShare.class),
        @XmlElement(type=SEC.class),
        @XmlElement(type=Route.class)
    })
    @XmlPaths({
        @XmlPath("fee[@type='Commission']"),
        @XmlPath("fee[@type='FINRAPerShare']"),
        @XmlPath("fee[@type='SEC']"),
        @XmlPath("fee[@type='Route']")
    })
    private List<Fee> fees;

}