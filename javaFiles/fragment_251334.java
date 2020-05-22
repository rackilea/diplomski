JButton[] gameButton = new JButton[rows * cols];
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        gameButton[i] = new JButton();
        ticTacToeBoard.add(gameButton[i]);
    }
}