sButton.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ae)
    {

        String ip = iField.getText();
        String uf = uField.getText();
       //pass it through the method to validate it
        if(isValidUser(uf))
       JOptionPane.showMessageDialog(yourFrameName, "your message.");
        if(isValidIP(ip))
       JOptionPane.showMessageDialog(yourFrameName, "your message.");

    }
});