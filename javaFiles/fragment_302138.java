public class SplashActivity extends Activity
{
    Handler Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

         Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData;
        if(appLinkAction!=null)
        appLinkData = appLinkIntent.getData();

        if(appLinkData!=null)
        {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
        finish();
         return;
        }else
        {

        Handler = new Handler();
        Handler.postDelayed(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            },
                1500);

       }
    }
}