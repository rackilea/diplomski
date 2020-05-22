@Entity
public class Student {
    ...
    @ManyToMany
    @JoinTable(
        name="STUDENT_TEACHER_COURSE", 
        joinColumns= { @JoinColumn(name="STUDENT_ID") },
        inverseJoinColumns= { @JoinColumn(name="TEACHER_ID") }
    )
    @MapKeyManyToMany(joinColumns = @JoinColumn(name="COURSE_ID",unique = false))
    protected Map<Course,Teacher> teachers ;
    ...
}