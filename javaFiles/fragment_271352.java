public class YourApplication extends Application {
@Override
public void onCreate() {
    super.onCreate();
    Parse.initialize(this, "id","key");
    }
}