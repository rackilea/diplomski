import java.util.Scanner;
import java.util.Arrays;

public class EmpArray {

        public static void main(String[] args){
            employee();
        }
        public static int employee(){

            Scanner input = new Scanner(System.in);

            int numEmp;
            System.out.println("Enter how many employees to be compared: ");
            numEmp = input.nextInt();    
            input.nextLine();
            Employee[] employees = new Employee[numEmp];

            for (int i = 0; i < numEmp; i++) {
                System.out.print("Enter your name: ");
                String employeeName = input.nextLine();
                System.out.println();
                System.out.print("Enter in your annual sales:");
                int employeeSales = input.nextInt();
                input.nextLine();
                System.out.println();
                //creates an Employee object based on the constructor defined in Employee
                Employee employee = new Employee(employeeName, employeeSales);
                employees[i] = employee;    
            }
            //initialize maxSeller to first employee
            Employee maxSeller = employees[0];
            for(int i = 0; i < employees.length; i++){
                //using the getters we created in Employee
                System.out.println("Employee Name: " + employees[i].getName());
                System.out.println("Total Sales: " + employees[i].getSales());
                System.out.println();
                //checks if employees[i] sold more than maxSeller
                if(maxSeller.getSales() < employees[i].getSales()){
                    maxSeller = employees[i];
                }
            }
            System.out.println();
            System.out.println("Top Seller: " + maxSeller.getName());
            System.out.println("Top Sales: " + maxSeller.getSales());

            return maxSeller.getSales();

        }
 }