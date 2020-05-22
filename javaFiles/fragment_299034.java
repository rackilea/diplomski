package forum10617267;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD) // here I need this access
public class User implements Serializable {

    @XmlTransient
    private Set<History> history = new HashSet<History>();

    @XmlElement
    private Set<History> getXmlHistory() {
         return history;
    }

    private void setXmlHistory(final Set<History> aHistory) {
        this.history = aHistory;
    }

}