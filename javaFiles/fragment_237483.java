import java.util.Scanner;

public class EmployeeInfo {

    String Str = "CS";

    public void empCheck(String empId) throws InvalidEmployeeException {

        if (!empId.startsWith(Str)) 

            // if (!CSXXX.equals(empId))
            throw new InvalidEmployeeException("Employee ID is inValid");
        else
            System.out.println("Employee ID is Valid");

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Main Starts....");
        EmployeeInfo ei = new EmployeeInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID");
        String w = sc.nextLine();

        try {
            ei.empCheck(w);
        } catch (InvalidEmployeeException iee) {
            System.out.println(iee);
        }
        System.out.println("Main End...");
    }

}