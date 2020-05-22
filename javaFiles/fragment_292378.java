import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int empNum;
    private double empSal;

    public Employee(int e, double s){
        empNum = e;
        empSal = s;
    }

    public int getEmpNum(){
        return empNum;
    }

    public double getSalary(){
        return empSal;
    }

    public static void main(String[]args){
        List<Employee> employeeList= new ArrayList<Employee>();

        while (employeeList.size() < 7) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Please enter your employee number:");
            int e = sc.nextInt();
            System.out.printf("Please enter your salary:");
            double s= sc.nextDouble();
            employeeList.add(new Employee(e, s));
        }
    }
}