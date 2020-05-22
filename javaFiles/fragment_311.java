@Entity
@Table(name = "jobs_run")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property = "id")
@IdClass(JobRunKey.class)
public class JobRun implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Id
    @Column(name = "run_id")
    private Long runId;

    @Column(name = "job_stream_id")
    private Long streamId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String jobType;

    @Column(name = "script")
    private String script;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumns({ @JoinColumn(name = "run_id", referencedColumnName = "run_id", insertable = false, updatable = false),
            @JoinColumn(name = "job_stream_id", referencedColumnName = "id", insertable = false, updatable = false) })
    private StreamRun stream;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobRun", orphanRemoval = true, targetEntity = JobDependencyRun.class)
    public List<JobDependencyRun> dependencies = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobRun", orphanRemoval = true, targetEntity = JobEvent.class)
    public List<JobEvent> events = new ArrayList<>();
    ...
}