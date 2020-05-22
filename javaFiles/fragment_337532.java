@FXML
private void restartGame(ActionEvent event)throws Exception{
  myGrid = new GridPane();
  black = new Image(Main.class.getResource("images/black.png"));
  white = new Image(Main.class.getResource("images/white.png"));
  empty = new Image(Main.class.getResource("images/empty.png"));
  for (int i = 0; i < 8; i++){ //Per righe
     for (int j = 0; j < 8; j++){ // Per colonne
        myGrid.add(square, i, j);
     }

  }
  myGrid.add(new ImageView(black), 3, 3);
  myGrid.add(new ImageView(black), 4, 3);
  myGrid.add(new ImageView(white), 4, 4);
  myGrid.add(new ImageView(white), 4, 3);
}