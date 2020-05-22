package forum11796699;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
public class Value {

    private String value;

    @XmlElement(nillable=true)
    @XmlPath("text()")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}