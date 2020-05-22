public class SystemProperties{

  public static final String OS_NAME;
  // other properties

  static{
    OS_NAME = System.getProperty("os.name");
    // initialize other properties

  }

}