import java.util.Scanner;

public class Bankomat
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // Declarer variables
        int[] trans = new int[10];
        int amount = 0;
        int balance = 0;
        int sum = 0;
        int theChoice = 1;

        while(theChoice != 4)
        {
            theChoice = menu();
            switch(theChoice)
            {
            case 1:
                System.out.println("\nDu valde \"deposit\"");
                System.out.print("State the value you want to take in: ");
                sum = in.nextInt();

                if(sum == 0)
                {
                    System.out.print("\nYou have given are wrong value.\n");
                }
                else
                {
                    amount = (int) + sum;
                    makeTransactions(trans, amount);
                }   

                break;

            case 2:
                System.out.println("\nDu valde \"withdrawal\"");
                System.out.print("\nState the value you want to take in: ");
                sum = in.nextInt();

                if(sum == 0)
                {
                    System.out.print("\nDu har angett ett felaktigt belopp.\n");
                }
                else
                {
                    amount = (int) - sum;
                    makeTransactions(trans, amount);
                }   

                break;

            case 3:
                System.out.println("\nDu valde \"Balance\"");
                showTransactions(trans,balance);
                break;
            case 4:
                System.out.println("\nDu valde \"Quit\"");
                break;
            }
        }
    }

    /**
     * MENU
     * @return val  skickar tillbaka input värdet
     */
    public static int menu()
    {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        // Den här delen kommer att skriva ut menu
        System.out.print("\n1. Deposit\t");
        System.out.print("2. Withdrawal\t");
        System.out.print("3. Balance\t");                   
        System.out.println("4. Quit");                                   
        System.out.print("Your choice: ");

        choice = in.nextInt();
        return choice;
    }

    /**
     *  This method will sum up all the ten latest transaction and show the balance 
     * @param trans   array that saves the latest transactions 
     * @param balance Int that sums up all the values
     */
    public static void showTransactions(int[] trans, int balance )
    {
        System.out.println();
        System.out.println("Tidigare transaktioner: ");
        System.out.println("-------------------------------------------\n");

        for(int i = 0; i < trans.length; i++)
        {
            if(trans[i] == 0)
            {
                System.out.print("");
            }

            else
            {
                System.out.print(trans[i] + "\n");
                balance = balance + trans[i];
            }
        }
        System.out.println("-------------------------------------------\n");
        System.out.println("Saldo: " + balance + "KR" + "\n" );
    }

    /**
     * This method saves the latest transaction
     * @param trans array that saves the latest transactions
     * @param amount int that saves the latest transaction
     */
    public static void makeTransactions(int[] trans, int amount)
    {
        int position = findNr(trans);
        if(position == -1)
        {
            moveTrans(trans);
            trans[trans.length - 1] = amount;
        }
        else
        {
            trans[position] = amount;
        }
    }

    /**
     * This metod will look for a empty position 
     * @param trans array that saves the latest transactions
     * @return position 
     */
    private static int findNr(int[] trans) 
    {
        int position = -1;

        for(int i = 0; i < trans.length; i++)
        {
            if (trans[i] == 0)
            {
                position = i;
                break;
            }
        }
        return position;
    }

    /**
     * This method will move the transaction 
     * @param trans array that saves the latest transactions
     */
    private static void moveTrans(int[] trans)
    {
        for(int i = 0; i < (trans.length - 1); i++)
        {
            trans[i] = trans[i + 1];
        }
    }
}