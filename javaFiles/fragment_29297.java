@Entity
@Table(name="department", catalog="student")
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer departmentId;

    @OneToOne
    @JoinColumn(name = "id")
    private DepartmentHead departmenthead;
}