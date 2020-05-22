public static TextView displayR;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recipe);

    displayR = (TextView) findViewById(R.id.textR);
    String name = getIntent().getStringExtra("name");
    displayR.setText(name);
}