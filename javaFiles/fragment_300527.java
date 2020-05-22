@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Course extends AbstractPersistable<Long> {

    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

}