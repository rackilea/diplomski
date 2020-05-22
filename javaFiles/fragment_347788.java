public class Clock{
  private static Object CLASS_LOCK = new Object();

  public static void doSomething(){
    ...
    synchronized(CLASS_LOCK){
      //something dangerous to all clocks, not just yours
    }
    ...
  }
}