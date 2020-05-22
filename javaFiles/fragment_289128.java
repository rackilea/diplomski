@Entity
public class Department {

    @Id
    @Column(name = "department_id")
    private Integer departmentId;

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "manager_id")
    private Manager manager;