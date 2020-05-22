@Entity
@Table (name="emp")
class Employee
{
    @Id
    @GeneratedValue
    @Column(name="EMP_ID")
    public long getId() {
        return id;
    }

    @Column(name="SURNAME", nullable=false)
    public String getName() {
        return name;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="EMP_ID")   // Column name on the Role table
    public List<Role> getRoles() {
        return tasks;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="DEPT_ID")
    public Department getDepartment() {
        return department;
    }

 }