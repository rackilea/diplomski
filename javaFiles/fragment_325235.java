public class MyFancyBean implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  public void businessMethod() {
    //use applicationContext somehow
  }

}