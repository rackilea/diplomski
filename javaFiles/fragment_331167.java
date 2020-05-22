public void swapView(String view) {
    if("gameover".equals(view)) {
         gameOverPanel.setGameData(startPanel.getGameData());
    }
    cl.show(getContentPane(), view);
    gameOverLabel.setText("<html><h1>You didn't answer correctly!</h1><hr><h2></h2><h3>Your score: " + gameData.getScore() + "</h3></html>");

}