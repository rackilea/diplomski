@Entity
public abstract class Student extends Person{

    @Formula("(SELECT p.active FROM person p WHERE p.id = id)")
    private Boolean active;
    private Integer grade;
}