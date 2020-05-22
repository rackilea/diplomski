public class Enemies {
    private Game game; // variable to hold Game reference:

    public Enemies(Game game) {
        this.game = game; // set the instance
    }

    public void getEnemy() {

        Random rand = new Random();
        String[] list = {"Skeleton", "Zombie"};
        // Game game = new Game();     // no longer need this