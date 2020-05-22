@Entity
@Table(name="departmenthead", catalog = "student")
public class DepartmentHead {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "departmenthead")
    private Department department;  
}