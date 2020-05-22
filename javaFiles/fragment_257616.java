public class Login extends Activity
{
Button btnSubmit = null;
EditText edUsername = null;
EditText edPassword = null;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);
    btnSubmit = (Button)findViewById(R.id.submit);
    edUsername = (EditText) findViewById(R.id.username);
    edPassword = (EditText) findViewById(R.id.password);
    btnSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ConnectToLogin connectToLogin = new ConnectToLogin();
            String url = getString(R.string.base_uri) + "/login";
            String username = edUsername.getText().toString();
            String password = edPassword.getText().toString();
            connectToLogin.execute(username , password , url);
        }
    });
}
public void doResult(Boolean sw)
{
    if(sw == true)
    {
        MessagePassing<Message> messagePassing = new MessagePassing<>();
        String url = getString(R.string.base_uri) + "/api/home";
        messagePassing.GetFrom(url);
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result","OK");
        setResult(Activity.RESULT_OK,returnIntent);
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
        finish();
    }
    else
    {
        Toast.makeText(this , "Authentication failed" , Toast.LENGTH_SHORT).show();
    }
}

private class ConnectToLogin extends AsyncTask<String , Void , Boolean>
{
    public  int CONNECTION_TIMEOUT=10000;
    public  int READ_TIMEOUT=15000;
    @Override
    protected Boolean doInBackground(String... params)
    {
        try
        {
            // param[0] = username
            // param[1] = password
            // param[2] = URL
            String username = params[0];
            String password = params[1];
            URL url = new URL(params[2]);
            java.net.CookieManager cookieManager = new java.net.CookieManager();
            CookieHandler.setDefault(cookieManager);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setReadTimeout(READ_TIMEOUT);
            conn.setConnectTimeout(CONNECTION_TIMEOUT);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("username", username)
                    .appendQueryParameter("password", password);
            String query = builder.build().getEncodedQuery();
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();
            conn.connect();
            int result = conn.getResponseCode();
            if ( result == HttpURLConnection.HTTP_OK)
            {
                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder input = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    input.append(line);
                }
                String strInput = input.toString();
                if(strInput.equals("ok"))
                    return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            String a = e.getCause().toString();
            return false;
        }
        return  false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        System.out.println("Login was =" + result);
        doResult(result);
    }
}
}