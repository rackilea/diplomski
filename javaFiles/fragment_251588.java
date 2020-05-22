public class TestLayout02 {

    public static void main(String[] args) {
        new TestLayout02();
    }

    public TestLayout02() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                /* Use an appropriate Look and Feel */
                try {
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                /* Turn off metal's use of bold fonts */
                UIManager.put("swing.boldMetal", Boolean.FALSE);

                //Schedule a job for the event dispatch thread:
                //creating and showing this application's GUI.
                createAndShowGUI();
            }
        });
    }

    public class CardLayoutDemo implements ItemListener {

        JPanel cards; //a panel that uses CardLayout
        final static String BUTTONPANEL = "Card with JButtons";
        final static String TEXTPANEL = "Card with JTextField";

        public void addComponentToPane(Container pane) {
            //Put the JComboBox in a JPanel to get a nicer look.
            JPanel comboBoxPane = new JPanel(); //use FlowLayout
            String comboBoxItems[] = {BUTTONPANEL, TEXTPANEL};
            JComboBox cb = new JComboBox(comboBoxItems);
            cb.setEditable(false);
            cb.addItemListener(this);
            comboBoxPane.add(cb);

            //Create the "cards".
            NewUser newUser = new NewUser();

            JPanel card1 = new JPanel();
            card1.add(new JButton("Button 1"));
            card1.add(new JButton("Button 2"));
            card1.add(new JButton("Button 3"));

            JPanel card2 = new NewUser();


            //Create the panel that contains the "cards".
            cards = new JPanel(new CardLayout());
            cards.add(card1, BUTTONPANEL);
            cards.add(card2, TEXTPANEL);

            pane.add(comboBoxPane, BorderLayout.PAGE_START);
            pane.add(cards, BorderLayout.CENTER);
        }

        public void itemStateChanged(ItemEvent evt) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, (String) evt.getItem());
        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
    protected void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public class NewUser extends JPanel {

        private static final long serialVersionUID = 1L;
        private JLabel lblUsername, lblPassword, lblConfirmMsg;
        private JPasswordField txtPassword, txtCPassword;
        private JTextField txtUsername, txtName;
        private JButton btnSave, btnCancel;
        JPanel panelNewUser;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        public NewUser() {

//            this.setSize(350, 270);
//            this.setLocation((screen.width - 500) / 2, ((screen.height - 350) / 2));
//            this.setLayout(null);

            setLayout(new GridBagLayout());

            panelNewUser = this;
            lblUsername = new JLabel("Username");
            lblPassword = new JLabel("Password");
            lblConfirmMsg = new JLabel("Re-enter Password");
            txtName = new JTextField();

            txtUsername = new JTextField(12);
            txtPassword = new JPasswordField(12);
            txtCPassword = new JPasswordField(12);
            btnSave = new JButton("Save");
            btnCancel = new JButton("Cancel");

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(2, 2, 2, 2);
            gbc.anchor = GridBagConstraints.WEST;

//            lblUsername.setBounds(30, 30, 100, 25);
            this.add(lblUsername, gbc);
//            txtUsername.setBounds(150, 30, 150, 25);
            gbc.gridx++;
            this.add(txtUsername, gbc);
//            lblPassword.setBounds(30, 70, 100, 25);
            gbc.gridx = 0;
            gbc.gridy++;
            this.add(lblPassword, gbc);
//            txtPassword.setBounds(150, 70, 150, 25);
            gbc.gridx++;
            this.add(txtPassword, gbc);
//            lblConfirmMsg.setBounds(30, 110, 110, 25);
            gbc.gridx = 0;
            gbc.gridy++;
            this.add(lblConfirmMsg, gbc);
//            txtCPassword.setBounds(150, 110, 150, 25);
            gbc.gridx++;
            this.add(txtCPassword, gbc);
//            btnSave.setBounds(60, 155, 100, 25);
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            this.add(btnSave, gbc);
//            btnCancel.setBounds(180, 155, 100, 25);
            gbc.gridx++;
            this.add(btnCancel, gbc);

            // This is a bad idea, use a DocumentFilter
            txtName.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE)
                                    || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Invalid Character",
                                        "ERROR", JOptionPane.ERROR_MESSAGE);
                        e.consume();
                    }
                }
            });
            // This is a bad idea, use a DocumentFilter
            txtUsername.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE)
                                    || (Character.isDigit(c)) || (c == KeyEvent.VK_DELETE))) {
                        getToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Invalid Character",
                                        "ERROR", JOptionPane.ERROR_MESSAGE);
                        e.consume();
                    }
                }
            });
            btnCancel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    resetField();
                    panelNewUser.setVisible(false);
                    System.out.println("hello");
                }
            });
            btnSave.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    //DatabaseHelper databaseHelper = new DatabaseHelper();
                    if (txtUsername.getText() == null
                                    || txtUsername.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Username",
                                        "Missing fields", JOptionPane.DEFAULT_OPTION);
                        txtUsername.requestFocus();
                        return;
                    }
                    if (txtPassword.getPassword() == null
                                    || txtPassword.getPassword().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Password",
                                        "Missing fields", JOptionPane.DEFAULT_OPTION);
                        txtPassword.requestFocus();
                        return;
                    }
                    if (txtCPassword.getPassword() == null
                                    || txtCPassword.getPassword().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                        "Confirm your password", "Missing fields",
                                        JOptionPane.DEFAULT_OPTION);
                        txtCPassword.requestFocus();
                        return;
                    }
                    if (!txtPassword.getText()
                                    .equals(txtPassword.getText())) {
                        JOptionPane.showMessageDialog(null,
                                        "Passwords do not match.", "ERROR",
                                        JOptionPane.DEFAULT_OPTION);
                        txtCPassword.requestFocus();
                        return;
                    }


                    if (true) {
                        JOptionPane.showMessageDialog(null,
                                        "A new user is created", "SUCCESS",
                                        JOptionPane.DEFAULT_OPTION);
                        resetField();
                    }


                }
            });

        }// constructor closed

//action listener
        public void resetField() {

            txtUsername.setText("");
            txtCPassword.setText("");
            txtPassword.setText("");
        }
    }// class closed
}