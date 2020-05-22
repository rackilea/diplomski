public abstract class BaseActivity extends AppCompatActivity {

    public final String tag;

    public BaseActivity() {
        super();
        tag = getClass().getSimpleName();
    }

    @Override
    protected void onDestroy() {
        App.getInstance().cancelRequests(tag);
        super.onDestroy();
    }

    protected <T> void addToRequestQueue(Request<T> request) {
        App.getInstance().addToRequestQueue(request, tag);
    }

}