public class MyComposite extends Composite {

  @Named("list")
  @Inject
  private HashMap<String, Ex> myMap;

  public MyComposite(Composite parent, int style) {
        super(parent, style);
  }

  @PostConstruct
  void postConstruct() {
        myMap.get("key");
  }
}