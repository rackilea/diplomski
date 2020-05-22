public class AllStudents {
    Student student;
    String phone;
    Location location;

    public AllStudents(Student student, String phone, Location location) {
        this.student = student;
        this.phone = phone;
        this.location = location;
    }

    public Student getStudent() {
        return student;
    }

    public String getPhone() {
        return phone;
    }

    public Location getLocation() {
        return location;
    }
}