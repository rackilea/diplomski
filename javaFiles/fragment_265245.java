public class AppProperties extends ReloadableProperties {

  public static final AppProperties INSTANCE; static {
    INSTANCE = new AppProperties();
    INSTANCE.init(Paths.get("application.properties"));
  }


  @Override
  protected void propertiesUpdated() {
    // run code every time a property is updated
  }

  public final DynProp wsUrl = new DynProp("ws.url");
  public final DynProp hiddenText = new DynProp("hidden.text");

}