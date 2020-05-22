public class Student {

    @CollectionOfElements
    @JoinTable(
        table=@Table(name="STUDENT_COURSE"),
        joinColumns=@JoinColumn(name="STUDENT_ID")
    )
    private Set<JoinedStudentCourse> joined = new HashSet<JoinedStudentCourse>();

}

public class Course {

    @CollectionOfElements
    @JoinTable(
        table=@Table(name="STUDENT_COURSE"),
        joinColumns=@JoinColumn(name="COURSE_ID")
    )
    private Set<JoinedStudentCourse> joined = new HashSet<JoinedStudentCourse>();

}