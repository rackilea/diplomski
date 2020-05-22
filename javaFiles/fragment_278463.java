public class State {
    private int x;

    State(int x) {  // package-private
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

public class Behavior {
    // Uses State, but is not a State and does not have a State

    public State doSomethingThatYieldsState(String s) {
        try {
            return new State(Integer.parseInt(s));
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    public int doSomethingWithState(State s, int y) {
        return y + s.getX();
    }

    public void doSomethingToState(State s) {
        s.setX(s.getX() + 1);
    }
}