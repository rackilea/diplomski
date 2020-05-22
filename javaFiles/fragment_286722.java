public class SplashActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_splash);

     // For playing Video
     VideoView view = (VideoView)findViewById(R.id.videoView);
     String path = "android.resource://" + getPackageName() + "/" + R.raw.video_file;
     view.setMediaController(null); // to hide the controllers
     view.setVideoURI(Uri.parse(path));
     view.start();         

     new Handler().postDelayed(new Runnable(){
      @Override
      public void run() {
               /* Create an Intent that will start the Menu-Activity. */
           Intent mainIntent = new Intent(SplashActivity.this , QuranDataActivity.class);
           SplashActivity.this.startActivity(mainIntent);
           SplashActivity.this.finish();
          }
       }, 4000);

   }

 }