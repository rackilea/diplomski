public class StartApplication
            extends Application {

        @Override
        public void onCreate() {
            super.onCreate();
            Realm.init(getApplicationContext());
        }
}