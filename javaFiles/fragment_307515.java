public class MyApplication extends Application {
    public static MyApplication context = null;

    public void onCreate() {
        super.onCreate();
        context = this;
    }
}