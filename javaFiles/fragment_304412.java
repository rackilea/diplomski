public void mockSuperClassTest(/*@Mocked final SuperClass superClass*/) {
  //same code here
}

class SuperClass {
  public final static String app = Util.getAppName();
  public SuperClass(String data) {
    //throw new IllegalArgumentException();
  }
  public String getApp() {
    return app;
  }
}