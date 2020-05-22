public class Bank{
  // ...
  public BankAccount getAccount(Integer accountNumber){
     return bankAccounts.get(accountNumber);
  }
}