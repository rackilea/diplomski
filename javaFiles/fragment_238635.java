GridBagLayout gbl=new GridBagLayout();
    setLayout(gbl);
    GridBagConstraints gbc=new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);

    JLabel jl = new JLabel("This is a JLabel!", SwingConstants.CENTER);
    jl.setBorder(BorderFactory.createLineBorder(Color.black));
    gbc.gridy = 0;
    gbc.gridx = 0;
    gbc.ipadx = 50;
    gbc.ipady = 50;
    add(jl, gbc);

    gbc.insets = new Insets(10, 10, 10, 10);
    JLabel jl2 = new JLabel("This is a JLabel!", SwingConstants.CENTER);
    jl2.setBorder(BorderFactory.createLineBorder(Color.black));
    gbc.gridy = 1;
    gbc.gridx = 1;
    gbc.ipadx = 50;
    gbc.ipady = 50;
    add(jl2, gbc);