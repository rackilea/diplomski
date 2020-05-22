package student.scores;
import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.*;
import student.scores.StudentScores.Student.StudentScoreComparator;




public class StudentScores{


   public static void main(String[] args) {
System.out.println("Welcome to the Student Scores Application.");

Scanner input = new Scanner (System.in);
System.out.println("Enter number of students: ");
int numStudents = input.nextInt();

List<Student> students = new ArrayList<>();

int counter = 1;
for(int i = 0; i < numStudents; i++) {
    int studentNum = counter++;
    System.out.println("\nStudent " + studentNum);
    System.out.println("Enter Student Last Name: ");
    String lastName = input.next();

    System.out.println("Enter Student First Name: ");
    String firstName = input.next();


    System.out.println("Enter Student Score: ");
    int score = input.nextInt();
    students.add(new Student(lastName, firstName, score));
}
Collections.sort(students);
System.out.println("Students in alphabetical order: ");
for (Student s : students) {
    System.out.println(s);       
}
System.out.println();

Collections.sort(students, new StudentScoreComparator());
System.out.println("Students by score:");
for (Student s : students) {
    System.out.println(s);