@Entity(name = "task")
public class Task implements Serializable {    

    // Id and 3 fields

    @JsonBackReference("task_list-task")
    @ManyToOne
    @JoinColumn(name="tasklist_id")
    private TaskList parentList;

    // 3 more fields

    // Constructor
    public Task() {}

    //Getters and Setters
}