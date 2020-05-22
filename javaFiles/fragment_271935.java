@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    try
    {
        Database db = new Database(this);
        int k = db.getCount();
        Log.d("The Number of Row : ", String.valueOf(k));

        if (k != 0)//If we already have an entry in the database then will move from the splash screen to the loginCode activity
        {
            finish();
            Intent intent1 = new Intent(SplashScreen.this, LoginCode.class);
            startActivity(intent1);
            overridePendingTransition(R.anim.action_fade_in, R.anim.action_fade_out);
        }

        else//if launching app the first time then we will need to register
        {
            finish();
            Intent intent2 = new Intent(SplashScreen.this, RegPasscode.class);
            startActivity(intent2);
            overridePendingTransition(R.anim.action_fade_in, R.anim.action_fade_out);
        }
    }finally {
        db.close();
    }
}