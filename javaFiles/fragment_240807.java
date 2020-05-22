public class AppController extends Application {
    private static AppController sInstance;
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
    super.onCreate();

    sInstance = this;
    }

    public static synchronized AppController getInstance() {
    return sInstance;
    }

    public RequestQueue getRequestQueue() {

            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(getApplicationContext());
            }

            return mRequestQueue;
        }

}