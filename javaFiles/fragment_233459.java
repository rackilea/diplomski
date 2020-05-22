@Entity
@Table(name="student")
public class Student
    @Id
    private Integer id;
    private String name;
    @Formula("(SELECT COUNT(*) FROM people)")  // people is table name not entity
    private Integer count;