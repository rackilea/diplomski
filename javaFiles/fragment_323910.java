public class WatchedInApplication implements Invoke {

  private WatcherInLibrary lib;

  public WatchedInApplication(WatcherInLibrary lib) {
    super();
    this.setLib(lib);
  }

  public WatcherInLibrary getLib() {
    return lib;
  }

  public void setLib(WatcherInLibrary lib) {
    this.lib = lib;
  }
  // where the method is implemented. 
  @Override
  public void invokeRemote(String data) {
    System.out.println("Method Invoked " + data.toString());
  }
}