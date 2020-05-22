@Module
public class TestModule {
  private final String arg1;
  private final int arg2;
  private final boolean arg3;

  public TestModule(String arg1, int arg2, boolean arg3) {
    this.arg1 = arg1;
    this.arg2 = arg2;
    this.arg3 = arg3;
  }

  @Provides DaggerTestClass provideDaggerTestClass() {
    return new DaggerTestClass(arg1, arg2, arg3);
  }
}