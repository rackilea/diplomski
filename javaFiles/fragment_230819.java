public class ExampleActivity extends Activity {
 MediaPlayer mp;    
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //other codes
    mp  = MediaPlayer.create(this, R.raw.seconds);
    mp.prepare();
    mp.start();
}
protected void onDestroy() {    
    //other codes
    mp.stop();
 }
}