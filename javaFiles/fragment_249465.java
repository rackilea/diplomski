int row = 0;
int col = 0;
for (final JToggleButton[] buttonRow : opponentFieldButtons) {
    col = 0;
    for (final JToggleButton button : buttonRow) {
        JToggleButton newButton = new JToggleButton("O");
        square.add(newButton);

        final int cRow = row;
        final int cCol = col;

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendCoor(cRow, cCol);
            }
        });
        opponentbg.add(Button1);
        col++;
    }
    row++;
}