@Entity
public class Class {
    @Id
    private String className;

    @OneToMany(cascade = Cascade.ALL, orphanRemoval = true)
    private List<Student> students=new ArrayList<>();

    // Constructors, Getters, Setter
}

@Entity
public class Student {
    @Id
    private String studentName;

    // Constructors, Getters, Setter
}