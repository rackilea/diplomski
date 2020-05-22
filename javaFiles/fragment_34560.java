public class InternetUtil {
    public static Observable<Boolean> isInternetOn() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public boolean call() throws Exception {
                return isOnline();
            }
        });
    }
}