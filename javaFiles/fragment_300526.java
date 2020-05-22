@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Student extends AbstractPersistable<Long> {

    private String first_name;
    private String last_name;

     @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "enrollment",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
     private List<Course> courses;

}