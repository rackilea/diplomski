public class QuestionView extends Activity {

    Quiz quiz = new Quiz();
    ArrayList<Question> queries = quiz.getRandom10();

    int correctAnswers = 0;
    int wrongAnswers = 0;

    int answer = 0;

    int i=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionviewmain);

        Button answer1 = (Button)findViewById(R.id.answer1);
        Button answer2 = (Button)findViewById(R.id.answer2);
        Button answer3 = (Button)findViewById(R.id.answer3);
        Button answer4 = (Button)findViewById(R.id.answer4);

        answer1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                if(answer == 0) {
                    correctAnswers++;
                } else {
                    wrongAnswers++;
                }
                reloadQuestion();
            }
        });

        answer2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                if(answer == 1) {
                    correctAnswers++;
                } else {
                    wrongAnswers++;
                }
                reloadQuestion();
            }
        });

        answer3.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                if(answer == 2) {
                    correctAnswers++;
                } else {
                    wrongAnswers++;
                }
                reloadQuestion();
            }
        });

        answer4.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                if(answer == 3) {
                    correctAnswers++;
                } else {
                    wrongAnswers++;
                }
                reloadQuestion();
            }
        });

        reloadQuestion();
    }


    private void reloadQuestion(){
        TextView question = (TextView)findViewById(R.id.question);

        Button answer1 = (Button)findViewById(R.id.answer1);
        Button answer2 = (Button)findViewById(R.id.answer2);
        Button answer3 = (Button)findViewById(R.id.answer3);
        Button answer4 = (Button)findViewById(R.id.answer4);

        question.setText(queries.get(i).getQuery());

        answer1.setText(queries.get(i).getA1());
        answer2.setText(queries.get(i).getA2());
        answer3.setText(queries.get(i).getA3());
        answer4.setText(queries.get(i).getA4());

        answer = queries.get(i).getCorrectAnswer();

        i++;
    }
}