public void mouseClicked(MouseEvent e) {
    int selectedX = -1;
    int selectedY = -1;
    for (int x = 0; x < 10; x++) {
        for (int y = 0; y < 10; y++) {
            if(playingGrid[x][y]== e.getSource()){
                playingGrid[x][y].setVisible(false);
                selectedX = x;
                selectedY = y;
            } else if (selectedX > 0 && selectedY > 0 && selectedX <= x && selectedY <= y) {
                playingGrid[x][y].setVisible(false);
            }
        }
    }
}