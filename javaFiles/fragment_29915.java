do {
  c.printf("enter the state for record:");
  stringState = null;
  state = State.undefined;
  try {
    stringState = c.readLine();
    state = State.valueOf(stringState);
  } catch (java.lang.IllegalArgumentException iae) {
    log.warning(Arrays.deepToString(State.values()));
  }
} while (title.getState() == State.undefined);