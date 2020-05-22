public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ssn;
    private String schoolId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Calendar enrollDate;

    // Constructors, getters/setters

    @Override
    public String toString() {
        return String.format("Student[%s,%s (%s)]", getLastName(),
                getFirstName(), getSchoolId());
    }
}