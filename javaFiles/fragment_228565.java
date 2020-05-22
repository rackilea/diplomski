public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.activity_main).addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
        @Override
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            if (bottom < oldBottom) {
                // View got smaller in height
                // In this case this means that the keyboard was opened
                findViewById(R.id.upToYoursImageView).setVisibility(View.GONE);
            } else {
                // View got larger in height
                findViewById(R.id.upToYoursImageView).setVisibility(View.VISIBLE);
            }
        }
    });
}