@Entity
@Table(name = "STUDENT")
public class Student {
    @PostLoad
    private void postLoad() {
        groupIds = groups.stream().map(Group::getId).collect(Collectors.toSet());
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Transient
    private Set<Long> groupIds;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="GROUP_STUDENT",
               joinColumns = @JoinColumn(name="GROUP_ID"),
               inverseJoinColumns = @JoinColumn(name="STUDENT_ID")
    )
    private Set<Group> groups = new HashSet<>();

    // getters and setters
}