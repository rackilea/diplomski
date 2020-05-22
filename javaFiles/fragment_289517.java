private rightPane rPane;
public leftPane(final rightPane rPane)
    {
        pane = new JPanel();
        this.rPane = rPane;
        staffLogin = new JButton("STAFF LOGIN");
        adminLogin = new JButton("ADMIN LOGIN");
        guestLogin = new JButton("GUEST LOGIN");

        staffLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rPane.trigerEvent();
            }
        });

        this.setLayout(null);

        this.add(staffLogin);
        this.add(adminLogin);
        this.add(guestLogin);

        staffLogin.setFont(new Font("Serif", Font.BOLD, 20));
        adminLogin.setFont(new Font("Serif", Font.BOLD, 20));
        guestLogin.setFont(new Font("Serif", Font.BOLD, 20));

        staffLogin.setBounds(20, 10, 200, 50);
        adminLogin.setBounds(20, 75, 200, 50);
        guestLogin.setBounds(20, 140, 200, 50);
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        pane.setBorder(BorderFactory.createLineBorder(Color.red));
    }