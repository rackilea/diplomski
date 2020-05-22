public class MainActivity extends Activity {

    Button btn;
    Button bReadFile;
    TextView tvRead;
    String value;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = (Button) findViewById(R.id.btnNext);
        bReadFile = (Button) findViewById(R.id.btnRead);
        tvRead = (TextView) findViewById(R.id.tvMain);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //trying to find a way to remove this button
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                startActivityForResults(intent,0);
            }
        });

        bReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tvRead.setText(value);
            }
        });
    }
    @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data){
       value = data.getStringExtra("key");
}
}