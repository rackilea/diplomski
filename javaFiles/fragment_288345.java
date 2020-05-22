public class PlayerRun implements Runnable{
    RunGame runGame;
    ...
    public PlayerRun(Player player, RunGame runGame) {
        this.player = player;
        this.runGame = runGame; 
    }
    ...
    @Override
    public void run() {
    while (true) {
    // DO YOUR WORK
    runGame.releaseCount();
    runGame.increaseCount();
    }
    }
}