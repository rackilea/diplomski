class ToActivity extends Activity {

    public static final String SERVER_PARAM = "server";
    public static final String UUID_PARAM = "uuid";
    public static final String TEMPLATE_PARAM = "template";

    private State state;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        state = initializeState();
        // MISSING NULL CHECK HERE!

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }

        // do stuff with state and extras
    }
}