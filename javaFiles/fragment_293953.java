public class PasswordForm {

    private static String password = "mypass";
    private JTextField usernameInput;

    public PasswordForm() {
    }

    private void init(){
         // Basic form create
        JFrame frame = new JFrame("Form 1");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating the grid
        JPanel panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        GridBagConstraints c = new GridBagConstraints();

        // Create some elements
        usernameInput = new JTextField(10);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(usernameInput,c);

        JPasswordField passwordInput = new JPasswordField(10);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(passwordInput,c);

        JButton loginInput = new JButton("Login");
        c.gridx = 0;
        c.gridy = 3;
        loginInput.addActionListener(new LoginButton());
        panel.add(loginInput,c);


        frame.setVisible(true);
    }
    public static void main(String[] args){
       PasswordForm form = new PasswordForm();
       form.init();
    }

    class LoginButton implements ActionListener{

        public void actionPerformed(ActionEvent e){
            //JTextField usernameInput = (JTextField)e.getSource();
            String username = (usernameInput.getText().length()>0?usernameInput.getText():" U have not entered!");
            JOptionPane.showMessageDialog(null,"Text is : "+username);
        }
    }
}