public class SystemProperties{

  public static String OS_NAME;
  // other properties

  @PostConstruct
  private void init(){
    OS_NAME = System.getProperty("os.name");
    // initialize other properties

  }

}