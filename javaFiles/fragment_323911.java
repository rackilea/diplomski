public class WatcherInLibrary {

  private Invoke obj;

  public void setWatchedApplication(Invoke object) {
    this.obj = object;
  }

  public void invokeRemoteObject() {
    this.obj.invokeRemote("data passed");
  }

}