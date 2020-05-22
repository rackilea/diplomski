public class AnActivity extends Activity {
    Context context;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mood);
    context = this;
    Button buttonMusic=(Button) findViewById(R.id.button5);
    buttonMusic.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            MyApplication myApplication = ((MyApplication)context.getApplication());//Changed "the" to "context"
            Toast.makeText(MoodActivity.this, "playing music", Toast.LENGTH_SHORT).show();
        }
    });

    }

}