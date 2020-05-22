@Entity
@Table(name = "Employee")
public class Employee {

    @EmbeddedId
    private EmployeeId id;

    private Integer id2_manager;

    @PrePersist
    @PreUpdate
    public void prePersistUpdate() {
        if (manager != null)
            id2_manager = manager.getId().getId2();
    }

    public Employee() {
    }

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public EmployeeId getId() {
        return id;
    }

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumns({ @JoinColumn(name = "id1", referencedColumnName = "id1", insertable = false, updatable = false),
            @JoinColumn(name = "id2_manager", referencedColumnName = "id2", insertable = false, updatable = false, nullable = true) })
    private Employee manager;

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}