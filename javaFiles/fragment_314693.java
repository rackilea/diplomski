@XStreamAlias("student")
public class Student {
    String firstname;
    String lastname;

    @XStreamAlias("marks")
    private Marks marks;

    @XStreamAsAttribute
    @XStreamAlias("studentid")
    String student_id;
}