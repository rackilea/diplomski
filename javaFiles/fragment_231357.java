BankAccount newbankaccount = new BankAccount(5);
if (newbankaccount.getBalance() < 6.0)
{
    // illegal withdrawal
}
else
    newbankaccount.withdraw(6.0);