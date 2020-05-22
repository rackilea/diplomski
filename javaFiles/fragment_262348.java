private void withdrawAccountInfo(int an)
{    
    for(int s=0;s<=9;s++)
    {
        if(savings[s].getAcct_No()==an)
        {
            // do your withdrawal process here with variable "s"; not "index"
            savings[s].setWithdraw(Integer.parseInt(JOptionPane.showInputDialog("Enter amount to withdraw")));
            JOptionPane.showMessageDialog(null,"Your balance is: " + (savings[s].getBalanceW()));
            savings[s].setAmount(savings[s].getBalanceW());
            // do more process
            break;
        }
    }
}