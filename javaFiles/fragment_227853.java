// Build the array of fields, I used a col by row matrix
JTextField fields[][] = new JTextField[12][12];
for (int col = 0; col < 12; col++) {

    for (int row = 0; row < 12; row++) {

        fields[col][row] = new JTextField(col + "x" + row, 8);

    }

}

// Build the groups...
for (int row = 0; row < 12; row++) {

    gbc.gridx = 0;

    int col = 0;

    add(buildGroup(fields, col, row, 0, 0, 1, 1), gbc);

    col += 3;
    gbc.gridx++;
    add(buildGroup(fields, col, row, 0, 0, 1, 1), gbc);

    col += 3;
    gbc.gridx++;
    add(buildGroup(fields, col, row, 0, 0, 1, 1), gbc);

    col += 3;
    gbc.gridx++;
    add(buildGroup(fields, col, row, 0, 0, 1, 0), gbc);

    gbc.gridy++;
    row += 2; // This is important, don't miss this ;)

}

public JPanel buildGroup(JTextField[][] fields, int startCol, int startRow, int top, int left, int bottom, int right) {

    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBorder(new MatteBorder(top, left, bottom, right, Color.RED));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(2, 2, 2, 2);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {

            // Get the field to use for this cell 
            JTextField field = fields[col + startCol][row + startRow];
            gbc.gridx = col;
            gbc.gridy = row;

            panel.add(field, gbc);

        }
    }

    return panel;

}