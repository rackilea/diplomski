import javax.xml.bind.annotation.*;

@XmlRootElement
public class Root {

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}