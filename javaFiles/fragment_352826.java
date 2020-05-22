public class Splash extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            Thread myThread=new Thread(){
               @Override
            public void run() {
                try {
      Animation anim = AnimationUtils.loadAnimation(this, R.anim.viewanimation);
                    logo.startAnimation(anim);  
//sleep time after animation
                    sleep(3000);  
//to end the splash screen and call next activity with Intent
                    finish();
                    Intent intent = new Intent(Splash.this,MainActivity.class);
                    startActivity(intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            };
            myThread.start();

        }
    }