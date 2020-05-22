public class User {
    private int id;
    private String lastName;
    private String name;
    private School school;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public School getSchool() {
        return school;
    }
    public void setSchool(School school) {
        this.school = school;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", lastName=" + lastName + ", name=" + name
                + ", school=" + school + "]";
    }
}