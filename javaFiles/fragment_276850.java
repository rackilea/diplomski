class Square {

  enum State { EMPTY, NOUGHT, CROSS }

  private ReadOnlyObjectWrapper<State> state = 
    new ReadOnlyObjectWrapper<>(State.EMPTY);

  public ReadOnlyObjectProperty<State> stateProperty() {
    return state.getReadOnlyProperty();
  }

  public State getState() {
    return state.get();
  }

  public void pressed() {
    if (!game.isGameOver() && state.get() == State.EMPTY) {
      state.set(game.getCurrentPlayer());
      ...
    }
  }
}