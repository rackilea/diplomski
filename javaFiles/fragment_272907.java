@Entity(name = "task_list")
public class TaskList implements Serializable {

    // Id and two fields

    @JsonManagedReference("task_list-task")
    @OneToMany(mappedBy="parentList")
    private List<Task> tasks;

    // Constructor
    public TaskList() {}
}