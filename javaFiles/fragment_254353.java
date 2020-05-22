import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SectionDivider {
  public static void main(String[] args) {
    List<Student> students =
        Arrays.asList(
            new Student(1, 95f, "S", 1),
            new Student(2, 95f, "S", 1),
            new Student(3, 93f, "S", 1),
            new Student(4, 75f, "B", 3),
            new Student(5, 74f, "B", 3),
            new Student(6, 83f, "A", 2),
            new Student(7, 83f, "A", 2),
            new Student(8, 83.5f, "A", 2),
            new Student(9, 70f, "B", 3),
            new Student(10, 71f, "B", 3),
            new Student(11, 96f, "S", 1),
            new Student(12, 60f, "C", 4),
            new Student(13, 65f, "C", 4),
            new Student(14, 62f, "C", 4),
            new Student(15, 71f, "B", 3));

    int numberOfSections = 4;
    String[] divided = new String[numberOfSections];
    int divIdx = 0;

    Map<Integer, List<Student>> groupedGrades =
        students
            .stream()
            .sorted((d1, d2) -> d1.gradeId.compareTo(d2.gradeId))
            .collect(Collectors.groupingBy(d -> d.gradeId));

    while (true) {
      boolean allEmpty = true;
      for (Entry<Integer, List<Student>> entry : groupedGrades.entrySet()) {
        List<Student> value = entry.getValue();
        int size = value.size();
        for (int i = 0; i < numberOfSections && i < size; i++) {
          allEmpty = false;
          if (divided[divIdx] == null) {
            divided[divIdx] = "";
          }
          divided[divIdx] = divided[divIdx].concat(value.get(0).grade);
          divIdx = (divIdx + 1) % numberOfSections;
          value.remove(0);
          entry.setValue(value);
        }
      }
      if (allEmpty) {
        break;
      }
    }

    Arrays.stream(divided).forEach(System.out::println);
  }
}

class Student {
  Integer id;
  Float marks;
  String grade;
  Integer gradeId;

  public Student(Integer id, Float marks, String grade, Integer gradeId) {
    super();
    this.id = id;
    this.marks = marks;
    this.grade = grade;
    this.gradeId = gradeId;
  }
}