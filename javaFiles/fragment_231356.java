try
{
    BankAccount newbankaccount = new BankAccount(5);
    newbankaccount.withdraw(6.0);
}
catch (Exception e)
{
    // illegal withdrawal
}