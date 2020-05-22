public boolean getAccount(String accountNumber)
{
    for (Account account : accounts)
    {
        if(account != null)
        {
            if (account.getAccountNumber().equals(accountNumber))
            {
                account.printAccountDetails();
                System.out.println();
                return true;
            }
        }
    }
    return false;
}