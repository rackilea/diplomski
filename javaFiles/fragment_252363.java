public class IdleState implements State {
    ...
    void accept(StateCallbacks visitor) {
        visitor.onState(this);
    }
}