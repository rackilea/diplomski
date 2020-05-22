JLabel lbl_navn = new JLabel("Virksomhedsnavn:");
    JTextField txt_navn = new JTextField();

    JLabel lbl_adresse = new JLabel("Adresse:");
    JTextField txt_adresse = new JTextField();
    //Setting grid bag constraints
    GridBagConstraints c = new GridBagConstraints();
    // Grid position coordinates
    c.gridx = 0; c.gridy = 0;
    //Align panel in top-left corner
    c.anchor=GridBagConstraints.LINE_START;
    forms.add(lbl_navn, c);
    c.gridx = 1; c.ipadx = 195;
    forms.add(txt_navn, c);
    c.gridy = 1; c.gridx = 0; c.ipadx = 0;
    forms.add(lbl_adresse, c);
    c.gridx = 1; c.ipadx = 195;
    forms.add(txt_adresse,c);
    c.gridy = 2; c.gridx     = 0; c.ipadx = 0;
    forms.add(Box.createRigidArea(new Dimension(10, 10)),c);


    c.anchor=GridBagConstraints.CENTER;
    c.gridy = 2; c.gridx = 1;
    forms.add(new JButton("Opret virksomhed"),c);