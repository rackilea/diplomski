import javax.xml.bind.annotation.XmlAttribute;

public class Task {

    @XmlAttribute
    private String id;

    public Task() {
    }

    public Task(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}