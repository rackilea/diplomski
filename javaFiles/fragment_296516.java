setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    for (int index = 0; index < 100; index++) {
        add(new JButton("Chat " + (index + 1)), gbc);
    }