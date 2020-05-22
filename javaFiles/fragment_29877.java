private CallbackManager callbackManager;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    FacebookSdk.sdkInitialize(getApplicationContext());

    callbackManager = CallbackManager.Factory.create();

    LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
    loginButton.setReadPermissions("public_profile", "email", "user_friends");

    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
            System.out.print("Logged in");
        }

        @Override
        public void onCancel() {
            // App code

        }

        @Override
        public void onError(FacebookException exception) {
            // App code
            Log.i("Error" , "Error");
        }
    });
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data); 
    callbackManager.onActivityResult(requestCode, resultCode, data);
}