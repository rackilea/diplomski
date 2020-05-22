public class Payroll
{
    public double hoursWorked; // should not be static

    public double hoursWorked() //should be getHoursWorked() and should have setter
    {
        return hoursWorked;
    }

    public Payroll setHoursWorked(double hoursWorked)
    {
        this.hoursWorked = hoursWorked;
        return this; //returning itself instead of 'void' allows method chaining
    }

    public double hourlyRate; // should not be static

    public double hourlyRate() //should be getHourlyRate() and should have setter
    {
        return hourlyRate;
    }

    private double taxedPay; // Declare taxedPay as a double

    public double taxedPay() //should be getTaxedPay() and should have setter
    {
        return taxedPay;
    }

    private double netPay; 

    public double netPay() //should be getNetPay() and should have setter
    {
        return netPay;
    }

    private double grossPay; // should not be static, should have getter/setter
    private double overtimePay; // should not be static, should have getter/setter
    private double overtimeHours; // should not be static, should have getter/setter

    public static void main(String[] args)
    {
        int i = 8; //you are basically using this variable only as a substitute for "while(true)".
        Scanner input = null;
        try
        {
            input = new Scanner(System.in); // should not re-allocate the Scanner each call, it is a resource that is ought to be closed
            do // should just use a do-while loop
            {    
                String firstName;
                System.out.println("\nEnter Your First Name: (Enter the name quit (all lowercase)     to terminate application)\n");
                firstName = input.next();

                if("quit".equals(firstName)) //this way, the app doesn't crash with NullPointerException if firstName is null
                {
                    System.out.println("You have terminated the Application. Have a nice day.\n");
                    break;
                }

                String lastName;
                System.out.println("\nEnter Your Last Name:\n ");
                lastName = input.next();

                String completeName;
                completeName = firstName + " " + lastName;
                System.out.println("\nHello " + completeName);

                PayRoll payRoll = new PayRoll(); //have an actual class for the data instead of using it statically
                //...
                payRoll.setHoursWorked(input.nextDouble()); //use setters like that, also there is no exception handling in case it's not a double from the input
                if(payRoll.getHoursWorked() < 0.1)
                {
                    //...
                }

                // ...
                // print print print print etc
            } 
            while(i < 9); //to be honest, this is not very descriptive, a boolean variable would say more about what is happening here and up to what point it is supposed to run and when this loop should end
        }
        finally
        {
            if(input != null)
            {
                input.close(); // Scanner is a resource that is meant to be closed after usage
            }
        }
    }
}