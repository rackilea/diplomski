public class LoginPage extends ActionBarActivity {
        Button loginbutton;
        EditText usernameuser, passworduser;
        DatabaseHandler db;
        String usernameinput, passwordinput;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_page);

            db = new DatabaseHandler(this); //initialize the DatabaseHandler
            //........