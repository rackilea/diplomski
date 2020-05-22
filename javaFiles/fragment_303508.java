public class SplashScreen extends AppCompatActivity {

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        //SharedPreference to Store API Result
        SharedPreferences pref = getApplicationContext().getSharedPreferences("CachedResponse", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.apply();

        email = pref.getString("login", null);

        int SPLASH_TIME_OUT = 3000;

        if (email != null) {

            //It means User is already Logged in so I will take the user to Select_College Screen

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    Intent intent = new Intent(SplashScreen.this, Select_College.class);
                    intent.putExtra("Email", email);
                    startActivity(intent);
                    finish();

                }

            }, SPLASH_TIME_OUT);

        } else {

            //It means User is not Logged in so I will take the user to Login Screen

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    Intent intent = new Intent(SplashScreen.this, Login.class);
                    startActivity(intent);
                    finish();

                }

            }, SPLASH_TIME_OUT);

        }

    }
}