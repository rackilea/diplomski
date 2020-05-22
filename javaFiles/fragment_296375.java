@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

//    @EmbeddedId
//    private Employee employeeId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "ID", unique = true, nullable = false, precision = 38)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}