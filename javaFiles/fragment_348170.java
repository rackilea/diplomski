public class controlCreator implements ApplicationContextAware {

  private ApplicationContext appContext;

  public Control createButton(){
    // since this bean is prototype, a new one will be created like this
    return getApplicationContext().getBean("myButton");
  }


  // ... getter and setter for applicationContext

}