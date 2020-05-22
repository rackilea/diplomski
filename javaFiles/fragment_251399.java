import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortTest
{
    public static class Student
    {
        String string;
        public Student(String s) { this.string = s; }
        public String getName() { return this.string; }
    }

    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("AA"));
        students.add(new Student("AC"));
        students.add(new Student("AB"));
        students.add(new Student("BA"));

        System.out.println("Initial Order of all students: ");
        for(Student student : students) { System.out.print(student.getName() + " "); }

        System.out.print("\nPick your letter: ");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.next();
        scanner.close();

        List<String> studentNames = students.stream()
        .filter(n -> n.getName().toUpperCase().startsWith(letter.toUpperCase()))   
        .sorted(Comparator.comparing(Student::getName))
        .map(Student::getName)
        .collect(Collectors.toList());

        System.out.println("\nNew order of names starting by " + letter + ":");
        for(String name : studentNames) { System.out.print(name + " "); }
    }
}