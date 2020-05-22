public class MainActivity extends Activity {

Context mContext = this;   

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ...
    SharedPreferences appPrefs = mContext.getSharedPreferences("com.example.gcmclient_preferences", Context.MODE_PRIVATE);
    String token = appPrefs.getString("token", "");
    if (token.isEmpty()) {
        try {
            getGCMToken("0123456789"); // Project ID: xxxx Project Number: 0123456789 at https://console.developers.google.com/project/...
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    ...
}
...

private void getGCMToken(final String senderId) throws Exception {
    new AsyncTask<Void, Void, Void>() {
        @Override
        protected String doInBackground(Void... params) {
            String token = "";
            try {
                InstanceID instanceID = InstanceID.getInstance(mContext);
                token = instanceID.getToken(senderId, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
                if (token != null && !token.isEmpty()) {
                    SharedPreferences appPrefs = mContext.getSharedPreferences("com.example.gcmclient_preferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor prefsEditor = appPrefs.edit();
                    prefsEditor.putString("token", token);
                    prefsEditor.commit();
                }
                Log.i("GCM_Token", token);
            } catch (IOException e) {
                e.printStackTrace();
            }    
            return null;            
        }           
    }.execute();
}   
}