/**
   Constructs a bank account with a zero balance.
*/
public BankAccount()
{   
   this(0);
}

/**
   Constructs a bank account with a given balance.
   @param initialBalance the initial balance
*/
public BankAccount(double initialBalance)
{   
    assert initialBalance >= 0;
    balance = initialBalance;
}