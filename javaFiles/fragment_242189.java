private boolean computerMove() {
    String[][] field = new String[3][3];

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            field[i][j] = buttons[i][j].getText().toString();
            if (field[i][j].equals("")) {
                buttons[i][j].setText("O");
                buttons[i][j].setTextColor(playerO);
                return true;
            }
        }
    }
    return false;
}