public class NotThatWellWrittenClass {
   private static final WorkUtil THE_WORK_UTIL = new WorkUtil();
   public static void do() {
      // could introduce thread safety issues as the object is now shared.
      THE_WORK_UTIL.do();
   }
}