public class LogThreadLocal{
    private static ThreadLocal<Log> t = new ThreadLocal();

    public static void set(Log log){}
    public static Log get(){}
    public static void clear(){}
}

Controller:saveFoo(){
    try{
        Log l = //create log from user and http request.
        LogThreadLocal.set(l);
        fooService.saveFoo(foo);
    } finally {
        LogThreadLocal.clear();
    }
}