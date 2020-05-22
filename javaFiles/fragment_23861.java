class MainActivity extends AppCompatActivity {
    Firebase mRef;
    Firebase mUsersRef;
    Firebase mPostsRef;

    ...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(...);
        ...
        mRef = new Firebase("https://yours.firebaseio.com");
        mUsersRef = mRef.child("users");
        mPostsRef = mRef.child("posts");
        ...
    }