int option = JOptionPane.showOptionDialog(null, spinner, "Enter valid number", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
if (option == JOptionPane.CANCEL_OPTION)
{
    // user hit cancel
} else if (option == JOptionPane.OK_OPTION)
{
    // user entered a number
}