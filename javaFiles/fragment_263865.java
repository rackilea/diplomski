public class GameMain extends Applet implements KeyListener {
    //...

    public void updateGameState() {
        droid.update();
        repaint();
    }

    //...