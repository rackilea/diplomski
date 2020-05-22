public class ScreenSaver {

  /*
   * Pipes are a shell feature, so you have to open a shell first.
   * 
   * You could use process.getInputStream() to read the output and parse it.
   * 
   * For productive use i would prefer using the Inputstream.
   */

  private static final String COMMAND = "gnome-screensaver-command -q |  grep -q 'is active'";

  private static final String[] OPEN_SHELL = { "/bin/sh", "-c", COMMAND };

  private static final int EXPECTED_EXIT_CODE = 0;


  public static boolean isScreenSaverActive() {
    final Runtime runtime = Runtime.getRuntime();
    Process process = null;
    try {
      /*
       * open a shell and execute the command in that shell
       */
      process = runtime.exec(OPEN_SHELL);
      /*
       * wait for the command to finish
       */
      return process.waitFor() == EXPECTED_EXIT_CODE;
    } catch(final IOException e) {
      e.printStackTrace();
    } catch(final InterruptedException e) {
      e.printStackTrace();
    }
    return false;
  }


  public static void main(final String[] args) {
    System.out.println("Screensaver is active: " + isScreenSaverActive());
  }

}