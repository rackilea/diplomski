@Entity
public class Class {
    @Id
    private String className;

    @OneToMany(
        mappedBy = "class",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Student> students=new ArrayList<>();

    // Constructors, Getters, Setter
    public void addStudent(Student student) {
        students.add(student);
        student.setClass(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setClass(null);
    }
}


@Entity
public class Student {
    @Id
    private String studentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Class class;

}