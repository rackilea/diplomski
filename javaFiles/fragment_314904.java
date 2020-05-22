package forum17527941;

import java.util.Date;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlPath("s:stackoverflow/s:information/s:date/text()")
    @XmlSchemaType(name="date")
    private Date date = new Date();

    @XmlPath("s:stackoverflow/s:information/s:name/text()")
    private String name;

}