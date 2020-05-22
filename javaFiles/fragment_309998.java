@Entity
public class StateDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StateID")
    private int stateId;

    @Column(name = "StateName")
    private String stateName;
}