@Entity
@Table(name="students")
public class Student {
private int studentId;// set the column name with @JoinColumn  annotation if you want
private int standard;// to be different from the variable name
private int grade;
private int age;
@OneToMany
@JoinTable(name="students_houses",
    joinColumns = @JoinColumn(name="studentId"),
    inverseJoinColumns = @JoinColumn(name="houseId"))
private List<House> houses;
// getters and setters
}