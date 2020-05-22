public class LoginActivity extends Activity 
{
    public static String TAG = "Login_Activity: ";

    private EditText usernameEditText;
    private EditText passwordEditText;

    private ProgressDialog progress_dialog;

    private int taskCount = 0;

    private void updateTaskCount(int value)
    {
        taskCount += value;

        if(progress_dialog != null && taskCount == 0)
        {
            progress_dialog.dismiss();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.login_username);
        passwordEditText = (EditText) findViewById(R.id.login_password);

        progress_dialog = new ProgressDialog(this);
    }

    public void LoginClick(View view)
    {       
        String URL = "http://SOME.com/api/Members?Username=" +                        
                      usernameEditText.getText().toString()+ "&Password=" +  
                      passwordEditText.getText().toString();

         progress_dialog.setMessage("Authenticating. Please wait...");
         progress_dialog.setCancelable(false);
         progress_dialog.show();

         new AuthenticateUserFromServer().execute(URL);
         updateTaskCount(1);

         new NotifyWebService ().execute("some other url");
         updateTaskCount(1);    
    }

    protected void onDestroy()
    {
        progress_dialog.dismiss();
        super.onDestroy();
    }

    @Override
    protected void onPause()
    {
        progress_dialog.dismiss();
        super.onPause();
    }

    private class AuthenticateUserFromServer extends AsyncTask <String, Void, String> 
    {
        protected String doInBackground(String... urls)
        {
            return Utility.readJSONFromWebService(urls[0]);
        }

        protected void onPostExecute(String result) 
        {   
            // do other stuff 
            updateTaskCount(-1);
        }
    }

    private class NotifyWebService extends AsyncTask <String, Void, String> 
    {
        protected String doInBackground(String... urls)
        {
            return Utility.readJSONFromWebService(urls[0]);
        }

        protected void onPostExecute(String result) 
        {   
            // do other stuff 
            updateTaskCount(-1);
        }
    }
}