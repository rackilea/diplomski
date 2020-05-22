gbc.gridx--;
if (gbc.gridx < 0) {
    gbc.gridx = 3;
    gbc.gridy++;
    gbc.weightx = 1;
} else {
    gbc.weightx = 0;
}