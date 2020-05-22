public class DisplayMessageActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_message);


    Intent intent = getIntent();
    String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
    TextView textView = new TextView(this);
    textView.setTextSize(40);
    textView.setText(message);

    RelativeLayout layout = (RelativeLayout) findViewById(R.id.rl_Container);
    layout.addView(textView);
}


}