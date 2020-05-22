public class MApplication extends Application {
public static Bus sBus = new Bus(ThreadEnforcer.MAIN);
@Override
public void onCreate() {
    super.onCreate();
    sBus.register(this);
}