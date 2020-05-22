@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Add this line with the appropriate ID reference
    text = (EditText)findViewById(R.id.your_edit_text_id);

    Button next = (Button) findViewById(R.id.Button01);
    next.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent myIntent = new Intent(view.getContext(), SecondScreen.class);
            startActivityForResult(myIntent, 0);
        }
    });
}