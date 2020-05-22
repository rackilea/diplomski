import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElementWrapper(name="content")
    @XmlAnyElement
    private List<Object> content;

    public Object getContent() {
        if(null == content || content.size() == 0) {
            return null;
        }
        return content.get(0);
    }

    public void setContent(Object content) {
        if(null == content) {
            this.content = null;
        } else {
            if(null == this.content) {
                this.content = new ArrayList<Object>(1);
            }
            this.content.set(0, content);
        }
    }

}