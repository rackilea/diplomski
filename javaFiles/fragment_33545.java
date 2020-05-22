setLayout(new GridBagLayout());

GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
for (int row = 0; row < 10; row++) {
    gbc.insets = new Insets(1, 1, 1, 1);
    for (int col = 0; col < 4; col++) {
        JButton btn = new JButton("Row " + row + " seat " + col);
        if (col == 2) {
            gbc.insets = new Insets(1, 40, 1, 1);
        } else {
            gbc.insets = new Insets(1, 1, 1, 1);
        }
        add(btn, gbc);
        gbc.gridx++;
    }
    gbc.gridy++;
    gbc.gridx = 0;
}