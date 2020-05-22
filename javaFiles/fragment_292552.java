String questionNumber = "";
EditText answer;
Button ok;
TextView question;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    answer = (EditText) findViewById(R.id.answer);
    ok = (Button) findViewById(R.id.btnOk);
    question = (TextView) findViewById(R.id.TextViewQuestion);

    getRandomQuestion();


    ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (answer.getText().toString().equals(questionNumber)) {
                Toast.makeText(getBaseContext(),"Input True", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "Input Wrong", Toast.LENGTH_LONG).show();
            }

            getRandomQuestion();
        }
    });
}

private void getRandomQuestion() {
    Random random = new Random();
    questionNumber = String.format("%04d",random.nextInt(10000));
    question.setText(questionNumber);
}