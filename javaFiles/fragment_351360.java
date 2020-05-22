public class LoginActivity extends FirebaseLoginBaseActivity {
    Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_chat);

      mFirebaseRef = new Firebase(...);

      ...
    }

    @Override
    protected Firebase getFirebaseRef() {
       return mFirebaseRef;
    }