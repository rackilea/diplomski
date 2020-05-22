@Entity
public class Project
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "task_id")
    private List<Task> task;

    public List<Task> getTask()
    {
        return task;
    }

    public void setTask(final List<Task> task)
    {
        this.task = task;
    }

    public Long getId()
    {
        return projectId;
    }

    public void setId(final Long id)
    {
        this.projectId = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }
}
@Entity
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

}