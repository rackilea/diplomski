import java.util.*;

public class AssignGrades {
    public static void main(String[] args) {

        // Prompt the user for the number of students
        System.out.println("Enter the number of students: ");
        Scanner scn = new Scanner(System.in);
        int numStudents = scn.nextInt();

        // Variable names start with lower case letter
        int[] grades = new int[numStudents]; // each student has one grade
        System.out.println("Enter the grades of " + numStudents + " students");
        for (int i = 0; i < numStudents; i++) {
            grades[i] = scn.nextInt();
        }

        // Call the method here
        convertGrades(grades);
        scn.close();
    }

    public static void convertGrades(int[] grades) {
        int maxGrade = maxGrade(grades);

        // Use System.out.println to print the values
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= maxGrade - 5) {
                System.out.println("A");
            } else if (grades[i] >= maxGrade - 10) {
                System.out.println("B");
            } else if (grades[i] >= maxGrade - 15) {
                System.out.println("C");
            } else if (grades[i] >= maxGrade - 20) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }
        }
    }

    public static int maxGrade(int[] grades) {
        int maxGrade = 0;

        // Shorten this
        for (int i = 0; i < grades.length; i++) {
           if(maxGrade < grades[i]) {
               maxGrade = grades[i];
           }
        }
        return maxGrade;
    }
}