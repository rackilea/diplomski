public class LoginFrame extends JFrame {

private JPanel contentPane;
private JTextField textField;
private JPasswordField passwordField;

public LoginFrame() {
    setTitle("LoginFrame");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 363, 270);
    contentPane = new JPanel();
    contentPane.setBackground(Color.ORANGE);
    contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
    setContentPane(contentPane);

    JLabel lblWelcome = new JLabel("Welcome");

    JLabel lblNewLabel = new JLabel("Username: ");

    textField = new JTextField();
    textField.setColumns(10);

    JLabel lblNewLabel_1 = new JLabel("Password: ");

    passwordField = new JPasswordField();

    JButton btnLogin = new JButton("Login");

    contentPane.setLayout(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(5, 5, 5, 5);

    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 2;
    c.anchor = GridBagConstraints.CENTER;
    contentPane.add(lblWelcome, c);

    c.gridwidth = 1;
    c.gridy = 1;
    contentPane.add(lblNewLabel, c);

    c.gridx = 1;
    contentPane.add(textField, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridy = 2;
    contentPane.add(passwordField, c);

    c.fill = GridBagConstraints.NONE;
    c.gridx = 0;
    contentPane.add(lblNewLabel_1, c);

    c.gridy = 3;
    c.gridwidth = 2;
    contentPane.add(btnLogin, c);
}

public static void main(String... s) {
    LoginFrame loginFrame = new LoginFrame();
    loginFrame.setVisible(true);
}
}