Customer{
   Account Saving = new Account();
   Account Checking = new Account();

   //you have something similar with input control
   void tranferFunds(Account from, Account to, double amount){

      from.Withdraw(amount);
      to.Deposit(amount);
   }

}

class Account
{
    double balance;
    Account()
    {
        balance = 0;
    }
    void deposit( double amount)
    {
        balance+=  amount;
    }
    void withdraw( double amount)
    {
        balance-=  amount;
    }
    double getBalance()
    {
        return balance;
    }
}