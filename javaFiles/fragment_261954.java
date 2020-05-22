public class Splash_screen extends AppCompatActivity {

int time = 3000;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_splash_layout);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(Splash_screen.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }, time);