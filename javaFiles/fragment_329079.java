public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Button pre = (Button) findViewById(R.id.button2);
        pre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish(); //add this

            }
        });
        //setContentView(R.layout.activity_display_message);//remove this

        Button next = (Button) findViewById(R.id.button3);//rename 'Next' to 'next'
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ThirdActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
     }
  }