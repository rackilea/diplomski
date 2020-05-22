public class MyParser implements Parser {
  private static Action DO_NOTHING = new Action() {
    public void doSomething() { /* do nothing */ }
  };

  public Action findAction(String userInput) {
    // ...
    if ( /* we can't find any actions */ ) {
      return DO_NOTHING;
    }
  }
}