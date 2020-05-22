public void newAccount()
{
    Account a = new Account();

    a.firstName = JOptionPane.showInputDialog("What's your first name?");
    a.nLastName = JOptionPane.showInputDialog("What's your last name?");
    a.nAddress = JOptionPane.showInputDialog("What's your current address?");
    a.nCity= JOptionPane.showInputDialog("What's your current city?");
    a.nState = JOptionPane.showInputDialog("What's your current State?");
    a.nZipCode = JOptionPane.showInputDialog("What's your current Zip Code?");

    account.add(a);
}