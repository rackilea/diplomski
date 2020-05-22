@Entity
public class University {

    @Id
    private String id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> students;

    // etc.
}