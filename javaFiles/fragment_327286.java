@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main); 
    // initialize after setContentview
    calculate = (Button) findViewById(R.id.button1);

    grade = (EditText) findViewById(R.id.editText1);
    wantedGrade = (EditText) findViewById(R.id.editText2);
    finalValue = (EditText) findViewById(R.id.editText3);

}