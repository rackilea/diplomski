public class SplashActivity extends Activity{

//timer in miliseconds, 1000ms = 1s//
private static int SPLASH_TIME_OUT = 2000;

//create first screen showed when app is launched//
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    new Handler().postDelayed(new Runnable() {
        //showing splashscreen with a timer //

        @Override
        public void run() {
            //this is executed once the timer is over//

            Intent i = new Intent(SplashActivity.this,    WelcomeActivity.class);
            startActivity(i);
            finish();

        }
    },SPLASH_TIME_OUT);

}
}