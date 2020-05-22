@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_splash_screen);
mAuth = FirebaseAuth.getInstance();
mUser = User.getInstance();

// New Handler to start the Menu-Activity and close this Splash-Screen after some seconds.
new Handler().postDelayed(new Runnable(){
    @Override
    public void run() {
        Logger.d("Start splash screen");
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
               if (user != null) {
                    // User is signed in
                    mUser.setLoginState(true);
                   mUser.setUiIdFirebase(user.getUid());
                    editor.putBoolean(USER_IS_LOGIN,true);
                    editor.putString(UI_ID_FIREBASE,user.getUid());
                    editor.commit();
                Log.d(TAG, "User state : signed_in:" + user.getUid());
                    StartMainActivity();
                    SplashScreen.this.finish();
               } else {
                    // User is signed out
                    mUser.setLoginState(false);
                    editor.putBoolean(USER_IS_LOGIN,false);
                    editor.commit();
                    Log.d(TAG, "User state : signed_out");
                    StartSignInActivity();
                    SplashScreen.this.finish();
                }
            }
        };
        //add listener
        mAuth.addAuthStateListener(mAuthListener);
    }
  }, SPLASH_DISPLAY_LENGTH);
}