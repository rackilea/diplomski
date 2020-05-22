public JPanel createBoardGame()
    JPanel boardGame = new JPanel(new GridLayout(numberOfRows,numberOfColumns));
    for (int i=0; i<numberOfRows*numberOfColumns; i++) {
        boardGame.add(new JButton(""));
    }
}