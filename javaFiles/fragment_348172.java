public class controlCreator implements ApplicationContextAware {

  private ApplicationContext appContext;

  public abstract Control createButton();


  // ... getter and setter for applicationContext

}