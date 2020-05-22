setLayout(new GridBagLayout());

GridBagConstraints gbc = new GridBagConstraints();
// This will add 50 pixels to the preferred size's width and height
gbc.ipadx = 50;
gbc.ipady = 50;
JButton[][] butArray = new JButton[3][3];
int size = 3;
for (int r = 0; r < size; r++) {
    for (int c = 0; c < size; c++) {

        butArray[r][c] = new JButton();
        add(butArray[r][c], gbc);

    }
}