public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int score = 0;
    private int help = 0;
    private boolean answerCorrect = true;       // dummy set always true for now
    private Button answerButton = null;         
    private Button hlpbtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerButton = (Button)findViewById(R.id.button_answer);
        answerButton.setOnClickListener(this);
        hlpbtn = (Button)findViewById(R.id.button_help);
        hlpbtn.setOnClickListener(this);
        hlpbtn.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_answer) {
            if(answerCorrect) {
                if((++score % 5) == 0) {
                    ++help;
                }
                if((help > 0) && !hlpbtn.isEnabled()) {
                    hlpbtn.setEnabled(true);
                }
            }
            Log.d("Quiz", "score = " + score + ", help = " + help);
        } else if(view.getId() == R.id.button_help) {
            if(--help <= 0) {
                hlpbtn.setEnabled(false);
                Log.d("Quiz", "help button disabled");
            }
            Log.d("Quiz", "help pressed, " + help + " remaining");
        }
    }
}