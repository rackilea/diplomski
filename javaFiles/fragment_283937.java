public class Game {
    volatile boolean running = true;
    Thread updateThread;
    Thread renderThread;

    public void Game() {
    }

    public void start() {
        Update update = new Update(this);
        updateThread = new Thread(update);
        updateThread.start();
        Render render = new Render(this);
        renderThread = new Thread(render);
        renderThread.start();
    }

    public void waitForFinish() throws InterruptedException {
        updateThread.join();
        renderThread.join();
    }

    boolean isRunning() {
        return running;
    }
}

class Update implements Runnable {
    private final Game game;

    Update(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        while (game.isRunning()) {
            try {
                Thread.sleep(1000);
                System.out.println("Update");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Render implements Runnable {
    private final Game game;

    Render(Game game) {
        this.game = game;
    }

    @Override
    public void run() {

        while (game.isRunning()) {
            try {
                Thread.sleep(100);
                System.out.println("Render");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

private void test() throws InterruptedException {
    Game game = new Game();
    game.start();
    game.waitForFinish();
}