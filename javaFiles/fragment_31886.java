@Entity
@Table(name="houses")
public class House {
private int houseId;
private String color;
private int houseCapacity;
@OneToMany
@JoinTable(name="students_houses",
    joinColumns = @JoinColumn(name="houseId"),
    inverseJoinColumns = @JoinColumn(name="studentId"))
private List<Student> students;
// getters and setters
}