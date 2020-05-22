public class TwitterActivity extends Activity 
{
    private boolean hasInternet = false;
    private Button mSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        mSignin = (Button)findViewById(R.id.login_id);
        mSignin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkInternet();
            }
        });
    } 

    private void checkInternet(){
        if(hasInternet)
            //do some stuff
        else
            new CheckInternetConnection().execute();
    }

    class CheckInternetConnection extends AsyncTask<Void, Void, Boolean>{
        @Override
        protected void onPostExecute(Boolean result){
            if(result)
                hasInternet = true;
            else
                hasInternet = false;

            checkInternet();
        }
        @Override
        protected Boolean doInBackground(Void... params) {
            return true;
        }
    }
}