public class FrameExample implements EntryPoint {

  public void onModuleLoad() {
    // Make a new frame, and point it at Google.
    Frame frame = new Frame("http://www.mydomain.com/path to my pdf");

    // Add it to the root panel. or anywhere you want
    RootPanel.get().add(frame);
  }
}