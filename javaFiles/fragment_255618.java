@SessionScoped
public class UserData implements Serializable {
  @Inject
  private Instance<Logger> logInstance;
  private String data;

  public Logger getLog() {
   return logInstance.get();
  }
}