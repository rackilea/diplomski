@Entity

public class Manager {

    @Id
    @Column(name = "manager_id")
    private Integer managerId;

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    private Employee employee;