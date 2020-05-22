public class TurnBasedGame {

    private static boolean gameIsRunning;
    private static AbstractGameState currentState;

    public static void main(String[] args) {
        while (gameIsRunning) {
            // very simplified game loop...

            // somehow handle the delta for the game loop...
            float delta;

            // update the game logic
            doGameUpdates(delta);

            // render game graphics here...
            render();
        }
    }

    private static void doGameUpdates(float delta) {
        currentState.update(delta);
    }
}