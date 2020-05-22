package forum12338288;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="worklist")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkList {

    List<Work> work;

}