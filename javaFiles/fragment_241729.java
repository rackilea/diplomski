public class YourClass extends Application {

        private static Context context;

        public void onCreate()
        {
            super.onCreate();
            YourClass.context = getApplicationContext();
        }

        public static Context getAppContext() {
            return YourClass.context;
        }
    }