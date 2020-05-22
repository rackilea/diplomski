public interface Action {
  void doSomething();
}

public interface Parser {
  Action findAction(String userInput);
}