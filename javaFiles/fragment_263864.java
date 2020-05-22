public class GameThread extends Thread {

    GameMain game;
    Droid droid;

    //...

    @Override
    public void run() {
        // Created a new GameMain
        game = new GameMain();
        // Created a new Droid...
        droid = new Droid();
        //Game while loop
        while (true) {

            droid.update();
            game.repaint();
            //...