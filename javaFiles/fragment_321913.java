import java.util.Scanner;

public class CurrencyExchangeClient
{
   public static void main(String[] args)
    {
       Scanner scan = new Scanner(System.in); // you shod use this scanner object for getting inputs


        System.out.print("Enter a dollar amount: ");
        double dollars = scan.nextDouble(); 

        System.out.println("Enter the currency to convert to (1) euro, (2) pound, (3) taka, (4) yen, (5) rupees : ");
        int response = scan.nextInt();

        // ...
        CurrencyExchange currencyExchange = new CurrencyExchange(dollars);

        switch (response)
        {
           case 1: // modified here to get the exact results as you need.
               currencyExchange.setEuro(dollars); // this will convert the entered dollar into euros
               System.out.println(currencyExchange.getEuro());// this will display the result
               break;
           //...change all other cases accordingly
        }

    }
}