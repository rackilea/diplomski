for (int row = 0; row < 9; row++) {

    gbc.gridwidth = 1;
    gbc.weightx = 0;

    int verSplit = 0;

    for (int col = 0; col < 12; col++) {

        gbc.gridx++;

        add(new JTextField(8), gbc);

        verSplit++;
        if (verSplit == 3) {

            verSplit = 0;

            gbc.gridx++;

            if (horSplit % 3 == 0) {

            gbc.gridheight = 3;
            gbc.fill = GridBagConstraints.VERTICAL;
            add(new JSeparator(JSeparator.VERTICAL), gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridheight = 1;

            }

        }

    }

    horSplit++;

    gbc.gridx = 0;

    if (horSplit == 3) {

        horSplit = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        add(new JSeparator(JSeparator.HORIZONTAL), gbc);

    }

    gbc.gridy++;

}