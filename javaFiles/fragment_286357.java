public class Player implements Runnable {

    final int playernum;

    public Player(int playernum) {
        this.playernum = playernum;
    }

    @Override
    public void run() {
        try {
            while (!a.finish) {

                synchronized (a.class) {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        System.out.println("player " + playernum + " does step " + i);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException interruptedException) {
        }
    }
}