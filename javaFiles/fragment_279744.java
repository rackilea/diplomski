import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of Student");

        int numberOfStudents = sc.nextInt();
        Student[] studentDetails = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            Student newStudent = new Student();

            System.out.println("enter f name");
            newStudent.setfName(sc.next());
            System.out.println("enter l name");
            newStudent.setlName(sc.next());
            System.out.println("enter Reg no");
            newStudent.setStuID(sc.next());
            System.out.println("enter Prj 1 marks");
            newStudent.setProjM1(sc.nextInt());
            System.out.println("enter ICT 1 Marks ");
            newStudent.setIctM1(sc.nextInt());
            System.out.println("enter Active P 1");
            newStudent.setActP1(sc.nextInt());
            System.out.println("enter Code Assg");
            newStudent.setCodeAsM(sc.nextInt());
            System.out.println("enter ICT 2 Marks");
            newStudent.setIctM2(sc.nextInt());
            System.out.println("enter Active P Marks");
            newStudent.setActP2(sc.nextInt());
            System.out.println("enter ICT 3 Marks");
            newStudent.setIctM3(sc.nextInt());
            System.out.println("enter Active P 3");
            newStudent.setActP3(sc.nextInt());

            studentDetails[i] = newStudent;

            System.out.println(newStudent);
        }

        sc.close();
    }

}