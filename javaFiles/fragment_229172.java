@Entity()
@Table(name = "university")
public class University extends BaseEntity {
    private String uniName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "university_id")
    private Collection<Student> students;

    //setters and getters
}