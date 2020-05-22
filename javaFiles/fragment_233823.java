public void actionPerformed(ActionEvent e) {
  for (int row = 0; row < ROWS; row++) {
    for (int col = 0; col < COLS; col++) {
       if buttonGrid[row][col] == e.getSource();
       // here you have your row and column
    }
  }
}