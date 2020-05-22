public class LineProcessor implements Runnable {
  private int currentLineNo = 0;
  Runnable LineProcessor = new LineProcessor();  // won't this cause infinite recursion?

  public LineProcessor() {
     // ...
  }

  @Override
  public void run() {
     // call getText();
     // call playAudio();
     currentLineNo++;

     SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           // *** Swing code can go here ***
        }
     });
  }
}