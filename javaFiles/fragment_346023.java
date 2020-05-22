public class qustionsActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_qustions);

    int a=new Random().nextInt(questions.length);

    final String[] questions = getResources().getStringArray(R.array.coupleQuestions);
    ArrayList<Integer> existingNumber=new ArrayList<>();

    final String randomQuestions = questions[a];

    existingNumber.add(a);

    final TextView theQuestion = findViewById(R.id.theQustion);

    theQuestion.setText(randomQuestions);

    Button nextQuestion = findViewById(R.id.nextQuestion);

    nextQuestion.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            do{
                 a=new Random().nextInt(questions.length);
            }while(!existingNumber.add(a))
            String randomQuestions = questions[a];
            theQuestion.setText(randomQuestions);
        }
    });
}