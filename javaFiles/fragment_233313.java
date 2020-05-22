public class MainActivity extends Activity {

private EditText mTextUserName;
private EditText mTextPassword;
public String user_name;
public String pass_word;
ConnectionClass cc;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mTextUserName = (EditText) findViewById(R.id.textUserName);
    mTextPassword = (EditText) findViewById(R.id.textPassword);

    cc=new ConnectionClass(this);
    final Button mButtonLogin = (Button) findViewById(R.id.buttonLogin);
    mButtonLogin.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            user_name = mTextUserName.getText().toString();
            pass_word = mTextPassword.getText().toString();

            user_name=Uri.encode(user_name); // you can encode your parameters so that it does not throw exception for e.g it will replace a space as %20 otherwise if user enters special character error will come.. :)
            pass_word=Uri.encode(pass_word); // same as above

            String url="http://myserver.com/login.php?username="+user_name"&password="+user_name; // this is your server page url and passing username and password in plain url u can test it in browser to verify its working :)

            new AsyncTask<String,Void,String>() // new android versions does not allow network operations on main thread but need to do asynchronously...
            {

               @Override
               protected String doInBackground(String... params) {

               return cc.getServerResponse(params[0]);
              }

              @Override
        protected void onPostExecute(String result) {  // this method runs on UI thread and is called when background process is done to make it more fancy u can use onPreExecute() to show a loader and dismiss the dialog here :)
            super.onPostExecute(result);
            if(result!=null)
            {
                if(result.equals("1")  // assuming u r returning "1" if successful.
                {
                    Toast.makeText(context, "Successful", 2000).show();
                    Intent goToNextActivity = new Intent(MainActivity.this, ViewActivity.class);
                    goToNextActivity.putExtra("username", user_name);
                    goToNextActivity.putExtra("password", pass_word);
                    startActivity(goToNextActivity);
                }
            }
            else
                Toast.makeText(context, "Network problem...", 2000).show();
        }

            }.execute(url);


            }


        }
    });
}