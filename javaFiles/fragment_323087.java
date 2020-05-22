import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    private List<Student> students = new ArrayList<Student>();

    public Main() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the details of student: ");

        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter address: ");
        String address = input.nextLine();
        System.out.println("Enter contact no: ");
        int no = input.nextInt();
        System.out.println("Enter rollno: ");
        int roll = input.nextInt();
        System.out.println("Enter marks");
        int marks = input.nextInt();
        Student s = new Student(name, address, no, roll, marks);
        students.add(s);
    }
}