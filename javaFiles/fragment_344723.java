case 4: {
     int accountNumber =  scan.nextInt();  // user types account number
     TreeMap <Integer, BankAccount> bankAccounts = bank.getAccounts();  // bank returns all accounts (this is quite an insecure operation, it would be better to add a method to the bank class that returns only one account when passing the accountNumber
     BankAccount bankAccount = bankAccounts.get(accountNumber);
     break;
}