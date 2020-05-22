final JPanel panel2 = new JPanel();
    panel2.add(new JLabel(" Testing Label 2"));

    panel2.setBorder(new TitledBorder("P2"));
    c = new GridBagConstraints();
    // You have to use BOTH for the panel to take
    // all vertical and horizontal space
    c.fill = GridBagConstraints.BOTH;