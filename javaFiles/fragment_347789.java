public class Clock{
  public static void somethingDangerous(){
    synchronized(Clock.class){
      //do something dangerous
    }
  }
}