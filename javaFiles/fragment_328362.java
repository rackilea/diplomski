@Embeddable
public class JoinedStudentCourse {

    // Lets suppose you have added this field
    @Column(updatable=false)
    private Date joinedDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="STUDENT_ID", insertable=false, updatable=false)
    private Student student;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COURSE_ID", insertable=false, updatable=false)
    private Course course;

    // getter's and setter's 

    public boolean equals(Object instance) {
        if(instance == null)
            return false;

        if(!(instance instanceof JoinedStudentCourse))
            return false;

        JoinedStudentCourse other = (JoinedStudentCourse) instance;
        if(!(student.getId().equals(other.getStudent().getId()))
            return false;

        if(!(course.getId().equals(other.getCourse().getId()))
            return false;

        // ATT: use immutable fields like joinedDate in equals() implementation
        if(!(joinedDate.equals(other.getJoinedDate()))
            return false;

        return true;
    }

    public int hashcode() {
        // hashcode implementation
    }

}