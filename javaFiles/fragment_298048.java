public class Courses {
    private int next;
    String[] studentArray;
    String classList;

    public Courses() {
        studentArray = new String[] { "CSCI 0066", "CHEM 003B", 
                "HUM 0002", "MATH 0032", "CHEM 003Y", "MATH 0031",
                "CSCI 0026", "PHYS 0105L", "PHYS 0105", "CSCI 0013", "ENGL 001C" };
        next = 0;
    }

    @Override
    public String toString() {
        return Arrays.stream(studentArray).collect(Collectors.joining(", "));
    }
}