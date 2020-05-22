public class TerminationObserverImpl {
  private void notifyDone(SlaveAlgorithm slave) {
    remove(slave); // Remove it from the list.
    terminateAll(); // Go through the list and terminate each slave.
  }
  ...