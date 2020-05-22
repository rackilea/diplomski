public class ConsoleParser<A> {
  public static <A> ConsoleParser<A> cli(CliCommand <A> command) {
    ...
  }
  public ConsoleParser <A> or (CliCommand <A> command) {
    ...
  }

  public A parse(String arg) throws CliParseException {
     // 
  }

}