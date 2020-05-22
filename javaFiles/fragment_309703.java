package pojo;

import java.util.HashMap;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "Party")
@XmlAccessorType(XmlAccessType.FIELD)
public class Party {

    @XmlPath(".")
    @XmlJavaTypeAdapter(MapAdapter.class)
    HashMap<String, String> partyInfo = new HashMap<String, String>();

}