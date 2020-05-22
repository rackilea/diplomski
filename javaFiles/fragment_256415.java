public class Userlogin extends AppCompatActivity implements View.OnClickListener {

        LoginButton btnFacebookLogin;
        CallbackManager callbackManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            FacebookSdk.sdkInitialize(getApplicationContext());
            setContentView(R.layout.activity_main);
            callbackManager = CallbackManager.Factory.create();
            setUI();
        }

        private void setUI() {


            btnFacebookLogin = (LoginButton) findViewById(R.id.btnFacebookLogin);

            btnFacebookLogin.setOnClickListener(this);
            btnFacebookLogin.setReadPermissions("email", "public_profile");

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.btnFacebookLogin:
                    facebookLogin();
            }
        }

        private void facebookLogin() {
    // Callback registration
            btnFacebookLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    // App code

                    final AccessToken accessToken = loginResult.getAccessToken();
                    GraphRequestAsyncTask request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject user, GraphResponse graphResponse) {
                            LoginManager.getInstance().logOut();
                            username = (user.optString("name"));
                        }
                    }).executeAsync();


                    Toast.makeText(getApplicationContext(), "Login Success with facebook", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Userlogin .this, AlertsandPlanning.class));


                }

                @Override
                public void onCancel() {
                    // App code
                }

                @Override
                public void onError(FacebookException exception) {
                    // App code
                }
            });

        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }