public class Vlogger{
    public static Class getInstance() {
       return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                         .getCallerClass();
    }
}