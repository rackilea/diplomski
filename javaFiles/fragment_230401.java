Button buttonOne;
Button buttonTwo;
Button buttonThree;
Button buttonFour;
TextView textQuestion;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_practice_questions);

    buttonOne = (Button) findViewById(R.id.answerOne);
    buttonTwo = (Button) findViewById(R.id.answerTwo);
    buttonThree = (Button) findViewById(R.id.answerThree);
    buttonFour = (Button) findViewById(R.id.answerFour);
    textQuestion = (TextView) findViewById(R.id.textQuestion);
    [...]
}