public class CookieApplication extends Application {
   @Override
   public void onCreate() {
      super.onCreate();
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
         CookieSyncManager.createInstance(this);
      }
   }
}