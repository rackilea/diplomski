@Entity
public class Step implements java.io.Serializable {
    private Long id;
    private String duration;
    private String stepType;
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    public Schedule getSchedule() { return schedule; }

    @Id @GeneratedValue
    public Long getId() { return id; }

    // getters, setters, equals, hashCode
}