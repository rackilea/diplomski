Button b1, b2, b3, b4;
Context context = this;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_intentt);
    b1 = (Button) findViewById(R.id.button2);
    b2 = (Button) findViewById(R.id.button3);
    b3 = (Button) findViewById(R.id.button4);
    b4 = (Button) findViewById(R.id.button5);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra(MainActivity.ID_ACTION, MainActivity.ACTION_1);
            startActivity(i);
        }
    });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra(MainActivity.ID_ACTION, MainActivity.ACTION_2);
            startActivity(i);
        }
    });
}