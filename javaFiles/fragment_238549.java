Main mMain ;
public void gameOver() throws IOException {
   String message = "Game, Want to try Again?";
   String title = "Game Over";
   int reply = JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION);
    if (reply == JOptionPane.YES_OPTION){
        frame.dispose();
        frame.setVisible(true);
    } else {
        this.getSoundEffect().stopAllMusic();
        if(mMain==null)
        {
          mMain = new Main();
        }
        mMain.setVisible(true);
    }
}