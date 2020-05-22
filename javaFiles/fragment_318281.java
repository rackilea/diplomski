public class NormalModeActivity1 extends AppCompatActivity {

    int Score = 0;
    boolean AnswerBig = false;
    boolean AnswerEqual = false;
    boolean AnswerSmall = false;
    int counter = 0;
    TextView X;
    TextView Y;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode1);

        // set class fields
        X = (TextView) findViewById(R.id.XNumber);
        Y = (TextView) findViewById(R.id.YNumber);
        score = (TextView) findViewById(R.id.ScoreDisplay);

        Random rnd = new Random();
        int Number1 = rnd.nextInt(99) + 1;
        String Xstring = String.valueOf(Number1);
        X.setText(Xstring);

        int Number2 = rnd.nextInt(99) + 1;
        String Ystring = String.valueOf(Number2);
        Y.setText(Ystring);

        if (Number1 > Number2) {
            AnswerBig = true;
        }
        if (Number1 == Number2) {
            AnswerEqual = true;
        }
        if (Number1 < Number2) {
            AnswerSmall = true;
        }

        findViewById(R.id.Bigger).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerBig) {
                    Toast.makeText(NormalModeActivity1.this, "(BIG)You are RIGHT!", Toast.LENGTH_SHORT).show();
                    Score++;
                    score.setText("Your Score Is: " + Score);
                    AnswerBig = false;
                } else {
                    Toast.makeText(NormalModeActivity1.this, "(BIG)You were WRONG!", Toast.LENGTH_SHORT).show();
                }
                incrementAndCheckCounter();
            }
        });

        findViewById(R.id.Equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerEqual) {
                    Toast.makeText(NormalModeActivity1.this, "(Equal)You were RIGHT!", Toast.LENGTH_SHORT).show();
                    Score++;
                    score.setText("Your Score Is: " + Score);
                    AnswerEqual = false;
                } else {
                    Toast.makeText(NormalModeActivity1.this, "(Equal)You were WRONG!", Toast.LENGTH_SHORT).show();
                }

                incrementAndCheckCounter();
            }
        });

        findViewById(R.id.Smaller).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AnswerSmall)
                {

                    Toast.makeText(NormalModeActivity1.this, "(Small)You were RIGHT!", Toast.LENGTH_SHORT).show();
                    Score++;
                    score.setText("Your Score Is: " + Score);
                    AnswerSmall = false;

                } else {
                    Toast.makeText(NormalModeActivity1.this, "(Small)You were WRONG!", Toast.LENGTH_SHORT).show();
                }
                incrementAndCheckCounter();
            }
        });

        String ScoreShow;
        ScoreShow = String.valueOf(Score);
        score.setText("Your Score Is: " + ScoreShow);
    }

    private void incrementAndCheckCounter() {
        counter++;
        if (counter > 5)
        {
            score.setText("ItsOver!!!");
        }
    }
}