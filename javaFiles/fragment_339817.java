import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Emp")
@XmlAccessorType(XmlAccessType.FIELD)
class Emp {

    String name;

    @XmlJavaTypeAdapter(CharacterAdapter.class)
    Character dateCheckFlag;

}