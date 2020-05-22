ParentAccount account;
if("Checking".equals(type)) {
    account = new CheckingAccount(BankAC, BankBalance);
} else {
    account = new ParentAccount(BankAC, BankBalance);
}

System.out.println(account);