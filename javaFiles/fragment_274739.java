@Override
protected State clone() throws CloneNotSupportedException {
    State state = new State(NUMBER_OF_CELLS);
    System.arraycopy(this.values, 0, state.values, 0, this.values.length);

    return state;
}