public class MainActivity extends AppCompatActivity {

Button b1;
EditText ed1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    b1 = (Button) findViewById(R.id.button);
    ed1 = (EditText) findViewById(R.id.editText);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String url = ed1.getText().toString();
            Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
            intent.putExtra("URL", url);
            startActivityForResult(intent, 1);

        }
    });
}


}