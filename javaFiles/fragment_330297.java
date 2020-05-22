public class Account
{

    private static int nextAccoutNumber = 0;

    private Customer cust;
    private double balance;

    Account(Customer c)
    {
       cust = c;
       balance = 0;
       accNum = ++nextAccountNumber;
    }
}