@Entity
@Table(name = "children")
public class ChildEntity {
    @Id
    @Column(name = "child_name")
    private String name;

    @Column(name = "child_value")
    private String value;

    @ManyToOne
    @JoinColumn(name="parent_id", updatable = false)
    private ScheduledReportsEntity scheduledReport;
    ...
}