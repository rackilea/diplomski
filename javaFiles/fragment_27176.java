@Entity
public class ProjectPlan {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "projectPlan", cascade = {CascadeType.ALL}, orphanRemoval=true)   // --> new attribute
    private List<Task> taskList;

    public ProjectPlan(){}

    public ProjectPlan(String id, String name, List<Task> taskList) {
        this.id = id;
        this.name = name;
        this.taskList = taskList;
    }
    //getter & setter
}

@Entity
public class Task {
    @Id
    private String id;
    private String name;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "projectId", referencedColumnName = "ID")
    private ProjectPlan projectPlan;

    public Task(){
    }

    public Task(String id, String name, ProjectPlan projPlan) {
        this.id = id;
        this.name = name;
        this.projectPlan = projPlan;
    }
    // getter & setter
}