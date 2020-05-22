@Entity
public class Schedule implements java.io.Serializable {
    private Long id;
    private String scheduleName;
    private Set<Step> steps = new HashSet<Step>();

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Step> getSteps() { return steps; }

    @Id @GeneratedValue
    public Long getId() { return id; }

    // getters, setters
}