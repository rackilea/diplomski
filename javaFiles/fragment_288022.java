@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="emptype",
    discriminatorType=DiscriminatorType.STRING
)
public abstract class Employee { 

    ... 

    private Employee manager;
    private Set<Employee> reportees = new HashSet<Employee>();

    @ManyToOne(optional = true)
    public Employee getManager() {
        return manager;
    }

    @OneToMany
    public Set<Employee> getReportees() {
        return reportees;
    }

    ...
}