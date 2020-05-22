int total3 = 0; //Instance variable.

Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.diabetes_question_3);

    .........
    Bundle extras = getIntent().getExtras();
    total3 = extras.getInt("totalScore");