public class MainActivity extends AppCompatActivity {
private int shakeCount=0;
private Runnable runnable ;
private Handler handler = new Handler();
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    runnable =new Runnable() {
        public void run() {
            if( shakeCount == 1 ) {
                final Intent tts = new Intent(context, ttsScreen.class);
                startActivity(tts);
            }
            else if (shakeCount == 2) {
                final Intent stt = new Intent(context, sttScreen.class);
                startActivity(stt);
            }
            else if (shakeCount == 3) {
                final Intent cbb = new Intent(context, cbbScreen.class);
                startActivity(cbb);
            }
            else if (shakeCount == 4) {
                final Intent ocr = new Intent(context, ocrScreen.class);
                startActivity(ocr);
            }
            shakeCount=0;
        }
    };
    mShakeDetector.setOnShakeListener(new com.example.name.project.ShakeDetector.OnShakeListener() {
        @Override
        public void onShake(final int count) {
            shakeCount=count;
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, 1800);

    });
}