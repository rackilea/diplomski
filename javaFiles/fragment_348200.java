String userId;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_profile);
    u_pro_img = (CircleImageView) findViewById(R.id.u_pro_img);
    u_user_name = (TextView) findViewById(R.id.u_user_name);
    u_fullname = (TextView) findViewById(R.id.u_fullname);
    u_bio = (TextView) findViewById(R.id.u_bio);
    u_fricou = (TextView) findViewById(R.id.u_fricou);
    add_fri = (Button) findViewById(R.id.add_fri);
    mUDBR = FirebaseDatabase.getInstance().getReference();

    user_id = (TextView) findViewById(R.id.user_id);


     //Getting data here UserId
      userId = getIntent().getStringExtra("USER_ID","");
Toast toast=Toast.makeText(getApplicationContext(),"USER ID "+userId ,Toast.LENGTH_SHORT);  

}}