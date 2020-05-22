GridBagConstraints gbc = new GridBagConstraints();
gbc.fill = GridBagConstraints.BOTH;
gbc.gridx = 0;
gbc.gridy = 0;

for (int row = 0; row < 4; row++) {

    gbc.gridx = 0;

    add(buildGroup(0, 0, 1, 1), gbc);
    gbc.gridx++;
    add(buildGroup(0, 0, 1, 1), gbc);
    gbc.gridx++;
    add(buildGroup(0, 0, 1, 1), gbc);
    gbc.gridx++;
    add(buildGroup(0, 0, 1, 0), gbc);
    gbc.gridy++;

}

public JPanel buildGroup(int top, int left, int bottom, int right) {

    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBorder(new MatteBorder(top, left, bottom, right, Color.RED));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {

            JTextField field = new JTextField(8);
            gbc.gridx = col;
            gbc.gridy = row;

            panel.add(field, gbc);

        }
    }

    return panel;

}