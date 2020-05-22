@Table(name = "JOB")
public class Job implements Serializable {
    @Id
    @Column(name = "JOB_ID", unique = true, nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "job")
    @Column(name = "PRINT_JOB_ID", length = 30)
    private JobDocument jobDocuments;
    . . .
}

// your response class, which wrap Job data
public class JobResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("jobDocuments")
    private JobDocument jobDocuments
    . . .
    // use this when you need to have jobDocuments 
    public static JobResponse fromJobWithDocuments(Job job) {
        this.id = job.getId();
        this.jobDocuments = job.getJobDocuments(); // you fetch lazy field, so it would be pre-populated
    }

    // use this when you don't need to have jobDocuments 
    public static JobResponse fromJob(Job job) {
        this.id = job.getId();
    }
}