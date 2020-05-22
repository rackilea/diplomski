public void calculateNewBalance()
{
    if (accountType.equals("S") || accountType.equals("s"))
    {
        accountType = "Savings";
        calculateSavingsBalance();

    } else if (accountType.equals("C") || accountType.equals("c"))
    {
        accountType = "Checking";
        calculateCheckingBalance();
    }


}