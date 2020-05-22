public class MainActivity extends Activity implements ConnectionCallbacks,OnConnectionFailedListener {
//google
private PlusClient plusClient;
private SignInButton btnSignIn;
private ProgressDialog connectionProgressDialog;
private ConnectionResult connectionResult;
private static final int REQUEST_CODE_RESOLVE_ERR = 9000;
//face
private LoginButton buttonLoginLogout;
private UiLifecycleHelper uiHelper;
static Usuario appusuario;
static String urldelogin="algo";
private Session.StatusCallback callback = new Session.StatusCallback() {
    @Override
    public void call(Session session, SessionState state, Exception exception) {
        onSessionStateChange(session, state, exception);
        if (session.isOpened()) {
            Log.e("usuario", "si hay sesion");
            // make request to the /me API
            Request.newMeRequest(session, new Request.GraphUserCallback() {

                // callback after Graph API response with user object
                @Override
                public void onCompleted(GraphUser user, Response response) {
                    if (user != null) {
                        Log.e("usuario", "si hay usuario");
                        buildUserInfoDisplay(user);
                        //start another activity
                        }
                }
            }).executeAsync();
        }
    }

    private void onSessionStateChange(Session session, SessionState state,
            Exception exception) {
        // TODO Auto-generated method stub
    }
};


@Override
public void onResume() {
    super.onResume();
    uiHelper.onResume();
}   

@Override
public void onPause() {
    super.onPause();
    uiHelper.onPause();
}   

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    uiHelper.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_CODE_RESOLVE_ERR &&
            resultCode == RESULT_OK)
        {
            connectionResult = null;
            plusClient.connect();
        }
}   

@Override
public void onDestroy() {
    super.onDestroy();
    uiHelper.onDestroy();
}   


@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    uiHelper.onSaveInstanceState(outState);
}
public static void buildUserInfoDisplay(GraphUser user) {

    appusuario=new Usuario(user.getName(),user.getUsername());
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    uiHelper = new UiLifecycleHelper(this, callback);
    uiHelper.onCreate(savedInstanceState);
    buttonLoginLogout = (LoginButton)findViewById(R.id.authButton);
    buttonLoginLogout.setReadPermissions(Arrays.asList("user_status"));

    btnSignIn = (SignInButton)findViewById(R.id.sign_in_button);
    buttonLoginLogout.setVisibility(View.VISIBLE);
    btnSignIn.setVisibility(View.VISIBLE);
    plusClient = new PlusClient.Builder(this, this, this).setActions("http://schemas.google.com/AddActivity", "http://schemas.google.com/BuyActivity")
            .build();

    connectionProgressDialog = new ProgressDialog(this);
    connectionProgressDialog.setMessage("Conectando...");

    btnSignIn.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View view)
        {
            if (!plusClient.isConnected())
            {
                if (connectionResult == null)
                {
                    connectionProgressDialog.show();
                }
                else
                {
                    try
                    {
                        connectionResult.startResolutionForResult(
                            MainActivity.this,
                            REQUEST_CODE_RESOLVE_ERR);
                    }
                    catch (SendIntentException e)
                    {
                        connectionResult = null;
                        plusClient.connect();
                    }
                }
            }
        }
    });


}

@Override
protected void onStart()
{
    super.onStart();
    plusClient.connect();
}

@Override
protected void onStop()
{
    super.onStop();
    plusClient.disconnect();
}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;

}

 @Override
    public void onConnected(Bundle connectionHint)
    {
        connectionProgressDialog.dismiss();
        //nombre
        String accountName = plusClient.getAccountName();
       //cuenta con mail
        Person accountperson=plusClient.getCurrentPerson();
        String personName = accountperson.getDisplayName();
        Log.e("Google +", "Conectado");
        //start another activity

    }

    @Override
    public void onDisconnected()
    {
        Log.e("Google +", "Desconectado");
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // TODO Auto-generated method stub
        if (connectionProgressDialog.isShowing())
        {
            if (result.hasResolution())
            {
                try
                {
                    result.startResolutionForResult(this,
                        REQUEST_CODE_RESOLVE_ERR);
                }
                catch (SendIntentException e)
                {
                    plusClient.connect();
                }
            }
        }
        connectionResult = result;

    }
      }