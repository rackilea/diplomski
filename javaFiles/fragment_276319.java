import java.util.Scanner;

public class EmployeeDriver {
    String employeeName;

    public void employeeName() {
        try {
            Scanner scannerName = new Scanner(System.in);
            System.out.println("Employye Name " + scannerName.nextLine());
            System.out.println("When did you hire the Employee");
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("The Employee name is " + scanner1.nextLine());
            System.out.println("What is the Employee's Number");
            Scanner scannerNum = new Scanner(System.in);
            System.out.println("The Employee name is " + scannerNum.nextLine());
        } catch (Exception e) {
            System.out.println("Error occurred" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("What is the Employee name");
        EmployeeDriver namingEmployeeObject = new EmployeeDriver();
        namingEmployeeObject.employeeName();
        Scanner scanner = new Scanner(System.in);
    }
}