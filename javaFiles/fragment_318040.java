public class Game {

    private static final int MAX_ROLLS = 10;

    private Roller roller = new Roller();
    private Counter counter = new Counter();
    private InputReader inputReader = new InputReader();

    public void start() {

        int rolls = 0;
        boolean continueRolling = true;

        while (rolls <= MAX_ROLLS && continueRolling) {

            Dice player1 = roller.roll();
            Dice player2 = roller.roll();

            counter.check(player1, player2);

            rolls++;

            continueRolling = inputReader.askUser();
        }

        counter.showResults();
    }

    public static void main(String[] args) {
        new Game().start();
    }
}