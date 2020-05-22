import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="task-list")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskList {

    @XmlElement(name="task")
    private List<Task> tasks;

}