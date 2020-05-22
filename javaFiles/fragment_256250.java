public class CheatActivity extends AppCompatActivity {


private static final String EXTRA_ANSWER_IS_TRUE = "com.example.ferhat.geoquiz.answer_is_true";
public static final String EXTRA_ANSWER_SHOWN = "com.example.ferhat.geoquiz.answer_shown";
public static final String EXTRA_CHEATED = "com.example.ferhat.geoquiz.cheated";
private static final String CHEATER = "com.example.ferhat.geoquiz.cheated";
private Boolean mAnswerIsTrue;
private TextView mAnswerTextView;
private Button mShowAnswer;
private Boolean mAnswerEverShown;
private Boolean twoStep=false;


//Yeni intent methodu yarattık Cevabı alıyor ve bu activity i başlatıyor
public static Intent newIntent(Context packageContext, boolean answerIsTrue, boolean checked) {
    Intent i = new Intent(packageContext, CheatActivity.class);
    i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
    i.putExtra(EXTRA_CHEATED, checked);
    return i;
}



private void setAnswerShownResult(Boolean isAnswerShown) {
    Intent data = new Intent();
    **if(mAnswerEverShown) {
        isAnswerShown=mAnswerEverShown;
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }else {
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
    twoStep=isAnswerShown;**

}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
    mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
    **mAnswerEverShown = getIntent().getBooleanExtra(EXTRA_CHEATED, false);**
    mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
    mShowAnswer.setOnClickListener(new View.OnClickListener() {

        //Cevabı gösteriyor ve Kopya çekildi bilgisi veriliyor
        @Override
        public void onClick(View v) {
            if (mAnswerIsTrue) {
                mAnswerTextView.setText(R.string.true_button);
            } else {
                mAnswerTextView.setText(R.string.false_button);
            }
            twoStep=true;
            setAnswerShownResult(twoStep);
        }

    });

    **if (savedInstanceState != null) {
        setAnswerShownResult(savedInstanceState.getBoolean(CHEATER, false));
    }
}
    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(CHEATER, twoStep);
    }
}**