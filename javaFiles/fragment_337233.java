myframe.addWindowListener(new WindowAdapter()
{
    public void windowClosing(WindowEvent e)
    {
        JOptionPane.showMessageDialog(null,"You entered " + firstName.getText() + ", " + lastName.getText() + ", " +password.getText());
    }
});