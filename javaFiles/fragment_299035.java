package forum10617267;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD) // here I need this access
public class User implements Serializable {

    @XmlTransient
    private Set<Values> values;

    @XmlElement
    private Set<History> getXmlHistory() {
         return new CustomSet<Values, History>(values);
    }

    private void setXmlHistory(final Set<History> aHistory) {
        this.values = new HashSet<Values>();
    }

}