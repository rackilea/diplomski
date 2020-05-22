public class SplashScreenActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class);
                SplashScreenActivity.this.finish();
            }
        }, 3000);

    }
}