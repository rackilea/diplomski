import java.util.ArrayList;
 import java.util.List;

 import org.apache.http.NameValuePair;
 import org.apache.http.message.BasicNameValuePair;
 import org.json.JSONException;
 import org.json.JSONObject;

 import android.app.Activity;
 import android.app.ProgressDialog;
 import android.content.Intent;
 import android.os.AsyncTask;
 import android.os.Bundle;
 import android.util.Log;
 import android.view.View;
 import android.view.View.OnClickListener;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.Toast;


 public class LoginActivity extends Activity implements OnClickListener
 {
     private EditText user, pass;
     private Button mSubmit, mRegister;

     private ProgressDialog pDialog;

     JSONParser jsonParser = new JSONParser();

     private static final String LOGIN_URL = "http://***.***.*.**.****/tappedin/login.php";


     private static final String TAG_SUCCESS = "success";
     private static final String TAG_MESSAGE = "message";

     @Override
     protected void onCreate(Bundle savedInstanceState) 
     {
         // TODO Auto-generated method stub
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_login);

         user = (EditText)findViewById(R.id.username);
         pass = (EditText)findViewById(R.id.password);

         mSubmit = (Button)findViewById(R.id.butLogin);
         mRegister = (Button)findViewById(R.id.butRegister);

         mSubmit.setOnClickListener(this);
         mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) 
    {
       // TODO Auto-generated method stub
       switch (v.getId()) 
       {
           case R.id.butLogin:
           new AttemptLogin().execute();
           break;
           case R.id.btnRegister:
           Intent i = new Intent(this, Register.class);
           startActivity(i);
           break;
           default:
           break;
       }
    }

    class AttemptLogin extends AsyncTask<String, String, String> {

    boolean failure = false;

    @Override
    protected void onPreExecute() 
    {
        super.onPreExecute();
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Logging in...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected String doInBackground(String... args) 
    {
        // TODO Auto-generated method stub
        int success;
        String username = user.getText().toString();
        String password = pass.getText().toString();
        try 
        {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", username));
            params.add(new BasicNameValuePair("password", password));

            Log.d("request!", "starting");
            JSONObject json = jsonParser.makeHttpRequest(
                   LOGIN_URL, "POST", params);

            Log.d("Login attempt", json.toString());

            success = json.getInt(TAG_SUCCESS);
            if (success == 1) {
                Log.d("Login Successful!", json.toString());
                Intent i = new Intent(LoginActivity.this, Profile.class);
                finish();
                startActivity(i);
                return json.getString(TAG_MESSAGE);
            }else{
                Log.d("Login Failure!", json.getString(TAG_MESSAGE));
                return json.getString(TAG_MESSAGE);

            }
        } 
        catch (JSONException e) 
        {
            e.printStackTrace();
        }

        return null;

    }
    protected void onPostExecute(String file_url) 
    {
        pDialog.dismiss();
        if (file_url != null)
        {
            Toast.makeText(LoginActivity.this, file_url, Toast.LENGTH_LONG).show();
        }

    }

  }

}`