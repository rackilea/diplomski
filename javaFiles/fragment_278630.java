@Entity
@Table(name = "Instructor")
public class Instructor {

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Courses> courses;
}