// this is method: 'bankAccountInstance.BankAccount()' 
public void BankAccount() 
{
    this.accountNumber = BankAccount.nextID++;
    //
}

// and this is method: 'bankAccountInstance.BankAccount("str", 5.1)' 
public void BankAccount(String accountHolder, double overdraftLimit)
{
    this.accountNumber = BankAccount.nextID++;
    //
}