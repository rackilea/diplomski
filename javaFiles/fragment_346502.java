public void reset(){
    game.this.setVisible(false);
    game.this.dispose();
    updateGamesPlayed();   
    new game();
}