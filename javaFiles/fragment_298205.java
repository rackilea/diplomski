public class Bank {
  // Your stuff
  // new method:
  public boolean transfer(Account accountFrom, double amount, String nameTo, int account) {
     //check if the balance can be deposit from the account
     if(amount <= accountFrom.getBalance()) {
        //Check if the person exists in the bank
        String name = nameTo.split(" "); // name[0] is the first name, name[1] last name

        boolean success = false;
        for(Customer c: customers) {
           if(c.getFirstName().equalsIgnoreCase(name[0]) &&
                     c.getLastName().equalsIgnoreCase(name[1]) {
              for(Account a : c.getAccounts()) {
                 if(a.getAccountId() == account) {
                    // Add it to the account
                    a.deposit(amount);
                    success = true;
                    break;
                 }
              }
              break;
           }
        }

        // Deposit it from the account (That class should only keep track of money, so it 
        // only takes an argument to deposit or withdraw a value, the rest is done by the bank
        // Only do this if money has been dsposited at the target account
        if(success){
          accountFrom.withdraw(amount);
          return true;
        }

     }
     return false;
  }
}