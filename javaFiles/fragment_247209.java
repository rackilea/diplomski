public void isServiceCharge()
{
    if(accountType.equals("s") || accountType.equals("S"))
    {
        double newBalance = currentBalance - 10.0;
        JOptionPane.showMessageDialog(null, "Account Number: " + getAccountNumber() + "\nAccount Type: " + getAccountType() + "\nMinimum Balance: $" + getMinSavings()
                + "\nBalance Before Interest and Fees: $" + getCurrentBalance() + "\n\nNew Balance: $" + newBalance);
    }
    else if(accountType.equals("c") || accountType.equals("C"))
    {
        double newBalance = currentBalance - 25.0;
        JOptionPane.showMessageDialog(null, "Account Number: " + getAccountNumber() + "\nAccount Type: " + getAccountType() + "\nMinimum Balance: $" + getMinSavings()
                + "\nBalance Before Interest and Fees: $" + getCurrentBalance() + "\n\nNew Balance: $" + newBalance);
    }

}