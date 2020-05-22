BattleShipButton[][] buttons = new BattleShipButton[boardWidth][boardHeight];
for(int i = (int)'a'; i < boardWidth; i++){
    for(int j = 0; j < boardHeight; j++) {
        buttons[i][j] = new BattleShipButton(new Coordinate((char)i, j));
    }
}