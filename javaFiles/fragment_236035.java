public class EndGameState extends AbstractGameState{
    @Override
    protected void updateState(float delta) {
        // this simple implementation just ends the game loop
        TurnBasedGame.gameIsRunning = false;
    }
}