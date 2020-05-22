public class Shell {

  public Process exec(String command) {
    return Runtime.getRuntime().exec(command);
  }

}