import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Content {

    private List<String> keywords;

    public Content() {}

    @XmlElementWrapper
    @XmlElement(name="keyword")
    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }  

}