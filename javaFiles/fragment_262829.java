RadioGroup2 rg = new RadioGroup2 ();
RadioButton [] rb = new RadioButton [3]();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

rb[0] = (RadioButton) findViewById(R.id.rb1);
rb[1] = (RadioButton) findViewById(R.id.rb2);
rb[2] = (RadioButton) findViewById(R.id.rb3);

rg.createRadioGroup(rb);
...
}