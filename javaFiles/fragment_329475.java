@Component
public class MyHandler {

  @AutoWired
  private MyDependency myDependency;

  @Value("${some.count}")
  private int someCount;

  /** Visible for testing. */
  MyHandler(MyDependency myDependency, int someCount) {
    this.myDependency = myDependency;
    this.someCount = someCount;
  }

  // ....
}