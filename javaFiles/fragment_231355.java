/**
   Withdraws money from the bank account.
   @param amount the amount to withdraw
*/
public void withdraw(double amount)
{   
    assert amount <= this.balance;

    this.balance -= amount;
}