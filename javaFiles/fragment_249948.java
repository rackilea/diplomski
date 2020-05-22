public class Student implements Comparable<Student> {
    private long id;
    private String givenName;
    private String surname;
    private Gender gender;
    private String course;

    public Student(long id, String givenName, String surname, Gender gender, String course) {
        this.id = id;
        this.givenName = givenName;
        this.surname = surname;
        this.gender = gender;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, givenName=%s, surname=%s, gender=%s, course=%s]", id, givenName, surname,
                gender, course);
    }

    /** Usually logic is left out of a POJO. */
    @Override
    public int compareTo(Student student) {
        return this.getGivenName().compareTo(student.getGivenName());
    }
}