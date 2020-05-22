public class StudentsTest {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("test.json");
        Students students = mapper.readValue(file, Students.class);

        for (Student s : students.getStudents().values()) {
            System.out.println(s);
        }
    }
}