public void actionPerformed(ActionEvent ae){
        submitBtn.setForeground(Color.red);               
        //getting value form the textFields
        String name = nameTxt.getText();
        String userName = userNameTxt.getText();
        char[] pass = password.getPassword();
        Object monthValue = month.getSelectedItem();
        String yearValue = yearTxt.getText();
        String dateValue = dateTxt.getText();
        Object genderValue = gender.getSelectedItem();
        String mobileValue = mobileTxt.getText();
        Object locationValue = country.getSelectedItem();

        JFrame showFrame = new JFrame("user details");
        showFrame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        showFrame.setSize(300, 400);
        showFrame.setLocation((screen.width - 500)/2,((screen.height-350)/2));  

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(BorderFactory.createTitledBorder("user Details"));
        JLabel nameVL = new JLabel("Name             :            " + name );
        nameVL.setBounds(80, 30, 200, 200);
        contentPane.add(nameVL); 

        showFrame.getContentPane().add(contentPane);               
        showFrame.setVisible(true);
        showFrame.setVisible(true);
    }