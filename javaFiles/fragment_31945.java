public class ForumInterface extends AppCompatActivity {
    private FirebaseFirestore db;
    private CollectionReference userRef;
    private ForumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_interface);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String forum_title = extras.getString("TITLE");
        String forum_type = extras.getString("FORUM_TYPE");
        String forum_id = extras.getString("FORUM_ID");

        db = FirebaseFirestore.getInstance();
        userRef = db.collection(forum_type).document(forum_id).collection(forum_title);

        TextView test = (TextView)findViewById(R.id.tvForumTitle);
        test.setText(forum_title);
    }
}