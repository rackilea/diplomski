class State {
  // make these non-final if you want State to be mutable
  // (I'm too lazy to generate getters; and in Scala you don't have to)
  public final int totalBooks = 0;
  public final String someOtherState = "hello";

  public State(final int totalBooks, final String someOtherState) {
    this.totalBooks = totalBooks;
    this.someOtherState = someOtherState;
  }

  public State withTotalBooks(final int newValue) {
    return new State(newValue, someOtherState);
  }
  public State withSomeOtherState(final int newValue) {
    return new State(totalBooks, newValue);
  }
}

class App {
  public static void main(final String[] args) {
    State state = new State();
    // at the top-most level of the program, it's OK to use global state
    state = BookManager.updateNumBooks(state)
  }
}

class BookManager {
  public static State updateNumBooks(final State state) {
    return state.withTotalNumBooks(123);
  }

  // or, if State is mutable:
  public static void updateNumBooks(final State state) {
    // UI code here
    state.totalNumBooks = 123;
  }      
}

class HelloModule {
  public static State updateMsg(final State state) {
    // UI code
    return state.withSomeOtherState("hello world");
  }

  // or, if State is mutable:
  public static void updateMsg(final State state) {
    // UI code
    state.someOtherState = "hello world";
  }
}

// etc