public class MainActivity extends ActionBarActivity { //mainactivity class

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 Button button = (Button) findViewById(R.id.button_id);
 button.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this,Second.class);
        startActivity(i);
      }
   });
 }