public class Crawford_Driver
{

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        double input1;
        String accountChoice;
        String accountActivity;
        RegularAccount regAcct = new RegularAccount(0, .5);
        SavingsAccount savAcct = new SavingsAccount(0, .5);


        do {
            System.out.println("What account would you like to access(regular or savings)?" );
            accountChoice = keyboard.nextLine();

            System.out.println("What action do you wish to perform(deposit, withdraw or monthly process)? ");
            accountActivity = keyboard.nextLine();


            if(accountChoice.equalsIgnoreCase("regular")) { // LINE moved and BRACKET MISSING

                if (accountActivity.equalsIgnoreCase("deposit"))
                {
                    System.out.println("How much would you like to deposit?");
                    input1= keyboard.nextDouble();
                    regAcct.deposit(input1);
                    System.out.println("Your balance is " + regAcct.getBalance() );
                }
                else if (accountActivity.equalsIgnoreCase("withdraw"))
                {
                    System.out.println("How much would you like to withdraw?");
                    input1= keyboard.nextDouble();
                    regAcct.withdraw(input1);
                    System.out.println("Your balance is "+ regAcct.getBalance());
                }
                else if (accountActivity.equalsIgnoreCase("monthly process"))
                {
                    regAcct.monthlyProcess();
                }
            } 
            else if (accountChoice.equalsIgnoreCase("savings")) 
            { // line changed &  BRACKET MISSING

                if (accountActivity.equalsIgnoreCase("deposit"))
                {
                    System.out.println("How much would you like to deposit?");
                    input1= keyboard.nextDouble();
                    savAcct.deposit(input1);
                    System.out.println("Your balance is " + savAcct.getBalance() );
                }
                else if (accountActivity.equalsIgnoreCase("withdraw")) 
                { // bracket missing

                    System.out.println("How much would you like to withdraw?");
                    input1= keyboard.nextDouble();
                    savAcct.withdraw(input1);
                    System.out.println("Your balance is "+ savAcct.getBalance());
               }
           }
       } while (!accountChoice.equalsIgnoreCase("Q"));
   }
}