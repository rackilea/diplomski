public class GameThread extends Thread {

    //...
    private GameMain gameMain;

    public GameThread(GameMain gameMain) {
        this.gameMain = gameMain;
        //...