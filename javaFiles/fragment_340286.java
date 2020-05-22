GoogleSignInOptions gso ;
     GoogleSignInClient mGSC ;


    @Override
    protected void onCreate (Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

     gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestProfile()
            .build();

     mGSC = GoogleSignIn.getClient(this, gso);
     findViews();


}