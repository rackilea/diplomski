import java.io.InputStream;
import java.util.Scanner;

public class run
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        Customer customer = new Customer(System.in);
        int accountChoice; // show which account needs to be chosen.
        String cusSel; //for customer selection.
        double money;
        do
        {
            System.out.println("main menu to be selected: " );
            System.out.println("1.deposit " );
            System.out.println("2.withdraw " );
            System.out.println("3.transfer " );
            System.out.println("4.print balance " );
            System.out.println("q.quit " );
            cusSel=in.next();
            switch(cusSel.charAt(0))
            {
            case '1':
                System.out.println("please select account: " );
                System.out.println("1. Checking" );
                System.out.println("2. Saving " );
                accountChoice=in.nextInt();
                if((accountChoice==1)||(accountChoice==2))
                {
                    System.out.println("please imput the deposit amount: " );
                    money=in.nextDouble();
                    if(accountChoice==1)
                    {
                        customer.deposit(money, "Checking");
                    }
                    else if(accountChoice==2)
                    {
                        customer.deposit(money, "Saving");
                    }
                }
                else
                {
                    System.out.println("invalid choice. your choice does not exsist");
                    break;
                }
                break;

            case '2':

                System.out.println("Please select account: " );
                System.out.println("1. Checking" );
                System.out.println("2. Saving " );

                accountChoice=in.nextInt();
                if((accountChoice==1)||(accountChoice==2))
                {
                    System.out.println("please input the withdraw amount: " );

                    money=in.nextDouble();


                    if(accountChoice==1)
                    {
                        customer.withdraw(money, "Checking");
                    }
                    else if(accountChoice==2)
                    {
                        customer.withdraw(money, "Saving");
                    }
                }
                else
                {
                    System.out.println("invalid choice. your choice does not exsist");
                    break;
                }
                break;

            case '3':

                System.out.println("please select an account to transfer from: " );
                System.out.println("1. Checking" );
                System.out.println("2. Saving " );

                accountChoice=in.nextInt();
                if((accountChoice==1)||(accountChoice==2))
                {
                    System.out.println("please input the withdraw amount: " );

                    money=in.nextDouble();

                    if(accountChoice==1)
                    {
                        customer.transfer(money, "saving");
                    }
                    else if(accountChoice==2)
                    {
                        customer.transfer(money, "checking");
                    }
                }
                else
                {
                    System.out.println("invalid choice. your choice does not exsist");
                    break;
                }
                break;

            case '4':
                customer.printBalance();
                break;
            case 'q':
                System.out.println("transaction complete, please have a nice day");
                break;
            default:
                System.out.println("invalid choice.");

            }

        } while (cusSel.charAt(0)!= 'q' && cusSel.charAt(0)!= 'Q');

    }
    private void getAccountChoice(int accountChoice) {
        // TODO Auto-generated method stub
    }

}

class Customer
{
    //two objects/ saving and checking
    Account Saving = new Account();
    Account Checking = new Account();
    public Customer(InputStream in)
    {
        // TODO Auto-generated constructor stub
    }
    boolean deposit(double amount, String acc)
    {
        double currentBalanceChecking, currentBalanceSaving;// this currentBalence is subtracted from and account.
        boolean retVal = false;
        switch (acc)
        {
        case "Checking":
            if(amount >=0)
            {
                currentBalanceChecking = this.Checking.deposit(amount);
                retVal = true;
            }
            break;
        case "Saving":
            if(amount >=0)
            {
                currentBalanceSaving = this.Saving.deposit(amount);
                retVal = true;
            }
            break;
        default:
            System.out.println("You entered an invalid number.");
        }
        return retVal;
    }
    boolean withdraw(double amount, String acc)
    {
        double currentBalanceChecking, currentBalanceSaving;// this currentBalence is subtracted from and account.
        boolean retVal = false;
        switch (acc)
        {
        case "Checking":
            if(amount >=0)
            {
                currentBalanceChecking = this.Checking.withdraw(amount);
                retVal = true;
            }
            break;
        case "Saving":
            if(amount >=0)
            {
                currentBalanceSaving = this.Saving.withdraw(amount);
                retVal = true;
            }
            break;
        default:
            System.out.println("You entered an invalid number.");
        }
        return retVal;
    }
    boolean transfer(double amount, String acc)
    {
        double currentBalanceChecking, currentBalanceSaving;// this currentBalence is subtracted from and account.
        boolean retVal = false;

    switch (acc)
    {
    case "Checking":
        if(amount >=0)
        {
            currentBalanceChecking = this.Checking.withdraw(amount);
            currentBalanceSaving = this.Checking.deposit(amount);
            retVal = true;
        }
        break;
    case "Saving":
        if(amount >=0)
        {
            currentBalanceSaving = this.Checking.withdraw(amount);
            currentBalanceChecking = this.Checking.deposit(amount);
            retVal = true;
        }
        break;
    default:
        System.out.println("You entered an invalid number.");
    }
    return retVal;
    }
    void printBalance()
    {
    }
    }


class Account
{
    double balance;
    //the constructor tells the customer that there are zero dollars in the account.
    Account()
    {
        balance = 0;
    }
    //deposit money
    double deposit( double depAmount )
    {
        balance= balance + depAmount;//balance+ = depAmount
        return balance;
    }
    double withdraw( double withAmount )
    {
        balance= balance - withAmount;//balance- = withAmount
        return balance;
    }

    double getBalance()
    {
        return balance;
    }
}