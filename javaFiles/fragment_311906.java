@Entity
@Table(name = "dm_action_plan",
       uniqueConstraints={ @UniqueConstraint(columnNames= "command","model") } )
public class ActionPlan {
    @Id
    private int pk;

    @Column(name = "command", nullable = false)
    private String command;

    @Column(name = "model", nullable = false)
    String model;
}