public Banka (float x, float y, boolean touch){
    this.currentX = x;
    this.currentY = y;
    this.touchDownTrue = touch;
    gameView = new GameView();
    gameView.isReady();
}