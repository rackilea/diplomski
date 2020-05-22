public class twitter_timeline extends Activity {
    //public static List<twitter4j.Status> STATUS_LIST; 
    List<twitter4j.Status> statuses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_timeline);

        setTitle("Timeline");
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            MyStatuses myStatuses = (MyStatuses) b.getSerializable("statuses");
            statuses = myStatuses.statuses;
        }
    }