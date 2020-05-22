import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Process {

    @XmlAttribute
    private String id;

    @XmlElement
    private List<Task> task;

    public Process() {
    }

    public Process(String id, List<Task> task) {
        this.id = id;
        this.task = task;
    }

    public String getId() {
        return id;
    }

    public List<Task> getTask() {
        return task;
    }
}