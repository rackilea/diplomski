private static final long   serialVersionUID    = 1L;

private static boolean      ranOnce             = false;

private JPanel              contentPane;
private static Registration     reg;
private JTextField          userTF;
private JTextField          passTF;
private JTextField          emailTF;
private LoginProcess lp = new LoginProcess();
private JLabel              error;
private JButton             cancelBtn;




public static synchronized Registration getRegistration()
{
    if(reg == null)
        reg = new Registration();

    return reg;


}

/**
 * Create the frame.
 */
private Registration()
{


    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 245, 212);
    setLocationRelativeTo(null);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblUsername = new JLabel("Username:");
    lblUsername.setBounds(10, 11, 75, 14);
    contentPane.add(lblUsername);

    JLabel lblPassword = new JLabel("Password:");
    lblPassword.setBounds(10, 36, 75, 14);
    contentPane.add(lblPassword);

    JLabel lblEmail = new JLabel("Email:");
    lblEmail.setBounds(10, 61, 75, 14);
    contentPane.add(lblEmail);

    userTF = new JTextField();
    userTF.setBounds(95, 8, 130, 20);
    contentPane.add(userTF);
    userTF.setColumns(10);

    passTF = new JTextField();
    passTF.setColumns(10);
    passTF.setBounds(95, 33, 130, 20);
    contentPane.add(passTF);

    emailTF = new JTextField();
    emailTF.setColumns(10);
    emailTF.setBounds(95, 58, 130, 20);
    contentPane.add(emailTF);

    error = new JLabel("");
    error.setBounds(10, 154, 215, 14);
    contentPane.add(error);

    JButton regBtn = new JButton("Register");
     regBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (!userTF.getText().equals("") || !passTF.getText().equals("") || !emailTF.getText().equals("")) {
                    try {
                        if (lp.newUser(userTF.getText(), passTF.getText(), emailTF.getText())) {
                        setVisible(false);
                            Main.mainFrame.setVisible(true);
                        } else {
                            if (lp.duplicateAccount) {
                                error.setText("Error: Username already in use.");
                            }
                        }
                    } catch (SQLException e) {

                    }
                }
            }
        });

    regBtn.setBounds(10, 120, 215, 23);
    contentPane.add(regBtn);

    cancelBtn = new JButton("Cancel");
    cancelBtn.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent arg0)
        {
             setVisible(false);

        }
    });
    cancelBtn.setBounds(10, 86, 215, 23);
    contentPane.add(cancelBtn);



}

public static void main(String[] args)
{
    Registration registration = Registration.getRegistration();
    registration.setVisible(true);
}