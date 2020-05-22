public class Thread {

    public static interface UncaughtExceptionHandler {
        //interface members
        void uncaughtException(Thread t, Throwable e);

   }
}