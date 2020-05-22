public class Welcome extends Activity {

 SessionManager session;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);

    session = new SessionManager(getApplicationContext());//<-- this is what you missed
    HashMap<String, String> user = session.getUserDetails();
    String userid = user.get(SessionManager.KEY_userid);


    Toast.makeText(this, userid+"", Toast.LENGTH_LONG).show();
  }
}