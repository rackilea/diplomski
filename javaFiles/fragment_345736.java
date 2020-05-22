public class WelcomeActivity extends Activity {
Button button;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
    addListenerOnButton();

}
public void addListenerOnButton() {

    final Context context = this;

    button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(context, "MainActivity Opened.", Toast.LENGTH_SHORT).show();

        }

    });
}
}