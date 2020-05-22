public void initialize() {
    super.setGameScreen(this.gameScreen);
    this.game = true;
    this.startGameLoop();
}

private void startGameLoop() {
    new Thread(){
        public void run(){
            while(game) {
                update();
                render();
            }
        }
    }.start();
}