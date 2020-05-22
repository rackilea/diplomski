public class Test
{
    public static void main(String args[])
    {
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JPasswordField password = new JPasswordField();
        final JComponent[] inputs = new JComponent[]
        {
            new JLabel("First"),
            firstName,
            new JLabel("Last"),
            lastName,
            new JLabel("Password"),
            password        
        };
        int i = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog",JOptionPane.PLAIN_MESSAGE);
        if(i == 0) System.out.println("You entered " + firstName.getText() + ", " + lastName.getText() + ", " + password.getText());
    }
}