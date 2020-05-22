import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class StackOverflow {

  private static class SO46310655 {
    public static void main(String[] args) {
      final List<Student> students = new ArrayList<>();
      students.add(new Student("Zoff", "Java 101"));
      students.add(new Student("Zoff", "CompSci 104"));
      students.add(new Student("Zoff", "Lit 110"));
      students.add(new Student("Andreas", "Kotlin 205"));
      Map<String, Set<String>> map = students.stream().collect(
          Collectors.groupingBy(
              Student::getStudentName,
              Collectors.mapping(
                  Student::getCourseTaking,
                  Collectors.toSet()
              )
          )
      );
      System.out.println(map);
    }

    public static class Student {
      private final String studentName;
      private final String courseTaking;

      public Student(String studentName, String courseTaking) {
        this.studentName = studentName;
        this.courseTaking = courseTaking;
      }

      public String getStudentName() {
        return studentName;
      }

      public String getCourseTaking() {
        return courseTaking;
      }
    }
  }
}