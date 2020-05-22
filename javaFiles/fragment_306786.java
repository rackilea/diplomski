public class Town {

    private State state;

    public Town() {}

    public Town(State state) {
      this.state = state;
      this.state.addTown(this);
    }

    public void setState(State state) {
      this.state = state;
      this.state.addTown(this);
    }

    public State getState() {
      return this.state;
    }
}