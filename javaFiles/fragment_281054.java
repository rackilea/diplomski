import java.util.List;
import javax.xml.bind.annotation.*;

@XmlSeeAlso({Country.class, City.class, Street.class})
public abstract class GeneralLocation {

    private String name;
    protected List<GeneralLocation> sons;

    @XmlAttribute(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementRef
    public List<GeneralLocation> getSons(){
        return this.sons;
    }

    public void setSons(List<GeneralLocation> sons){
        this.sons = sons;
    }

}