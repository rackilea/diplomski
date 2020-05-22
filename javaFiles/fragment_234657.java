public class MainActivity extends ActionBarActivity {

Button btn;
EditText t1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn = (Button) findViewById(R.id.button1);
    t1 = (EditText) findViewById(R.id.textView1);

    t1.setText(PreferenceValues.getInstance(getApplicationContext()).getDaysPresent());

    btn.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            PreferenceValues.getInstance(getApplicationContext()).setDaysPresent(t1.getText().toString());

        }
    });
}


@Override
protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    PreferenceValues.getInstance(getApplicationContext()).setDaysPresent(t1.getText().toString());
}