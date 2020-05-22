import java.text.NumberFormat;
  import java.util.Scanner; // importing the Java utility class scanner 

  public class WeeklyPay2 // class WeeklyPay
  {
 //main method
 public static void main(String[] args)
{
    Scanner scanner = new Scanner(System.in);
    NumberFormat format = NumberFormat.getCurrencyInstance();
    String employee_name = "";
    double hours_worked = 0, // variable for weekly hours worked
    pay_rate = 0, // variable for pay rate per hour
    weekly_pay = 0; // weekly pay = hours * pay_rate

    while (!employee_name.equalsIgnoreCase("stop"))
    {

        System.out.println();
        System.out.print("Employee Name: "); 

        employee_name = scanner.nextLine();

        if (employee_name.equalsIgnoreCase("stop"))  
        {  
            System.out.print("Exiting Program");  
            break;
        } // ends if statement  
        else
        {  
            System.out.print("Enter the hours worked for the week: ");
            //prompt, hours worked for the current week
            pay_rate = scanner.nextDouble();

            while(pay_rate < 0.01)
            {
                System.out.print("ERROR!!, Input a postive number:  ");
                pay_rate = scanner.nextDouble();
            }

            System.out.print("Enter the employees hourly pay rate: "); 
            // prompt, the employees pay rate
            hours_worked = scanner.nextDouble(); 

            while(hours_worked < 0.01)
            {
                System.out.print("ERROR!!, Input a postive number: \n");
                hours_worked = scanner.nextDouble();
            }

            weekly_pay = (double) hours_worked * (double) pay_rate; // setting the variable weekly_pay
            System.out.println(employee_name + "'s weekly pay is: " + format.format(weekly_pay)); // output the employees name and weekly pay
            scanner.nextLine();
        }
    }
    scanner.close();

} //ends main method
} //ends class WeeklyPay