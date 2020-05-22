JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel inforForNameLabel = new JLabel();
    inforForNameLabel.setText("Long Label Name.............................");
    inforForNameLabel.setAlignmentX(LEFT_ALIGNMENT);

    JLabel inforForNameLabel2 = new JLabel();
    inforForNameLabel2.setText("Long Label Name............................");
    inforForNameLabel2.setAlignmentX(LEFT_ALIGNMENT);

    final JTextField userNameTextField = new JTextField();
    userNameTextField.setText("aaaaaaaaaaaaa");
    userNameTextField.setEditable(false);
    userNameTextField.setPreferredSize(new Dimension(345, 30));
    userNameTextField.setMaximumSize(new Dimension(345, 30));
    userNameTextField.setAlignmentX(LEFT_ALIGNMENT);

    JLabel inforForNameSurname = new JLabel();
    inforForNameSurname.setText("Long Label Nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    inforForNameSurname.setAlignmentX(LEFT_ALIGNMENT);

    final JTextField NameSurnameTextField = new JTextField();
    NameSurnameTextField.setText("aaaaaaaaaaaa aaaaaaaaaa");
    NameSurnameTextField.setPreferredSize(new Dimension(345, 30));
    NameSurnameTextField.setMaximumSize(new Dimension(345, 30));
    NameSurnameTextField.setAlignmentX(LEFT_ALIGNMENT);

    JLabel inforForStatsCombobox = new JLabel();
    inforForStatsCombobox.setText("Long Label Name....................");
    inforForStatsCombobox.setAlignmentX(LEFT_ALIGNMENT);

    JComboBox statComboBox = new JComboBox();
    DefaultComboBoxModel dt = new DefaultComboBoxModel();
    statComboBox.setModel(dt);
    dt.addElement("USER.....");
    dt.addElement("ADMIN");
    statComboBox.setSelectedItem("USER.....");
    statComboBox.setPreferredSize(new Dimension(200, 30));
    statComboBox.setMaximumSize(new Dimension(200, 30));
    statComboBox.setAlignmentX(LEFT_ALIGNMENT);

    JLabel inforForAuthCombobox = new JLabel();
    inforForAuthCombobox.setText("Long Label Name................................");
    inforForAuthCombobox.setAlignmentX(LEFT_ALIGNMENT);

    String[] authComboBoxObjects = { "READ", "READ/WRITE"};
    final JComboBox authComboBox = new JComboBox(authComboBoxObjects);
    authComboBox.setSelectedItem("READ/WRITE");
    authComboBox.setPreferredSize(new Dimension(200, 30));
    authComboBox.setMaximumSize(new Dimension(200, 30));
    authComboBox.setAlignmentX(LEFT_ALIGNMENT);


    panel.add(inforForNameLabel);
    panel.add(inforForNameLabel2);
    panel.add(userNameTextField);
    panel.add(inforForNameSurname);
    panel.add(NameSurnameTextField);
    panel.add(inforForStatsCombobox);
    panel.add(statComboBox);
    panel.add(inforForAuthCombobox);
    panel.add(authComboBox);

    String[] buttons = { "EXIT", "OK" };
    int rc = JOptionPane.showOptionDialog(null, panel,"User Config", JOptionPane.INFORMATION_MESSAGE,JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1]);

    if(rc == 0 || rc == -1){
        System.out.println("Cancel...");
    }
    else{
        System.out.println(userNameTextField.getText());
    }