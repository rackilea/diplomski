public abstract class TurnGameState extends AbstractGameState{
    protected final void updateState(float delta){
        if (isWinConditionSatisfied()) {
            // end the game by setting the final state
            TurnBasedGame.currentState = new EndGameState();
        } else{
            update(delta);
        }
    }
    protected abstract void update(float delta);
    private boolean isWinConditionSatisfied() {
        // somehow check if the game is won
        return false;
    }
}