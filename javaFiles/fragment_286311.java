public class MainActivity extends Activity implements View.OnClickListener{
final String LOG_TAG = "mLog";    

Button btnConnect;

MyTask mt;

@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnConnect = (Button) findViewById(R.id.btnConnect);     

    btnConnect.setOnClickListener(this);
}

@Override
public void onClick(View v)
{
    mt = new MyTask();
    mt.execute();
}

class MyTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvResult.setText("Begin");
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {

            List<Map<String, String>> result = null;                

            try
            {                    
                Log.d(LOG_TAG, "start");

                ApiConnection con = ApiConnection.connect("IP");
                Log.d(LOG_TAG, "start2");
                con.login("login", "password");
                if(con.isConnected())
                {
                    //tvResult.setText("OK!");
                    Log.d(LOG_TAG, "isConnected");
                }                    
                result = con.execute("/interface/print");
                for(Map<String, String> res : result)
                {                       
                    Log.d(LOG_TAG, res.toString());
                }
                con.close();                   
            }
            catch (Exception e)
            {                   
                Log.d(LOG_TAG, "error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        tvResult.setText("End");
    }
}}