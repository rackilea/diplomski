public class StudentDTO {
    private final Student student;
    private String location;
    private List<String> phones = new ArrayList<>();

    public StudentDTO(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getPhones() {
        return phones;
    }
}