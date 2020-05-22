// this is constructor 'BankAccount b = new BankAccount()'
public BankAccount() 
{
    this.accountNumber = BankAccount.nextID++;
    //
}

// and this is constructor 'BankAccount b = new BankAccount("Account", 1.0)'
public BankAccount(String accountHolder, double overdraftLimit)
{
    this.accountNumber = BankAccount.nextID++;
    //
}