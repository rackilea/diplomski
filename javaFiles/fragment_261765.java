GridBagConstraints gbc = new GridBagConstraints();
   for (int i = 0; i < NUM_CHANNELS + 1; i++) {
        gbc.gridy = 0;
        textField[i] = new JTextField();

        textField[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        textField[i].setText("Channel " + (i + 1));

        add(textField[i], gbc);
        gbc.gridy = 1;
        add(sliders[i], gbc);
        gbc.gridx++;
    }