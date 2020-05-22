public class MainActivity extends AppCompatActivity {

    DBHelper questions;

    TextView mQuestion;
    TextView mAnswer1;
    TextView mAnswer2;
    TextView mAnswer3;
    TextView mAnswer4;
    CheckBox mCheckBox1;
    CheckBox mCheckBox2;
    CheckBox mCheckBox3;
    CheckBox mCheckBox4;
    Button mSubmit;

    long mCurrentQuestion = 0;
    int mCorrectAnswer = -1;
    int mCurrentAnswer = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion = (TextView) findViewById(R.id.question);
        mAnswer1 = (TextView) findViewById(R.id.answer1_text);
        mAnswer2 = (TextView) findViewById(R.id.answer2_text);
        mAnswer3 = (TextView) findViewById(R.id.answer3_text);
        mAnswer4 = (TextView) findViewById(R.id.answer4_text);
        mCheckBox1 = (CheckBox) findViewById(R.id.answer1_checkbox);
        mCheckBox2 = (CheckBox) findViewById(R.id.answer2_checkbox);
        mCheckBox3 = (CheckBox) findViewById(R.id.answer3_checkbox);
        mCheckBox4 = (CheckBox) findViewById(R.id.answer4_checkbox);
        mSubmit = (Button) findViewById(R.id.submit);
        mSubmit.setVisibility(View.INVISIBLE);
        setCheckBoxListeners();
        setSubmitButtonListener();

        questions = new DBHelper(this);         //Get Questions DBHelper
        questions.createProgresstable(questions.getWritableDatabase());

        if (questions.getRowCount() < 1) {
            addQuestions();
        }
        displayCurrentQuestion();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCurrentQuestion = questions.getNextQuestionID();

    }

    void displayCurrentQuestion() {
        mQuestion.setText("Sorry no questions are ready as yet");
        mAnswer1.setVisibility(View.INVISIBLE);
        mAnswer2.setVisibility(View.INVISIBLE);
        mAnswer3.setVisibility(View.INVISIBLE);
        mAnswer4.setVisibility(View.INVISIBLE);
        mCheckBox1.setVisibility(View.INVISIBLE);
        mCheckBox2.setVisibility(View.INVISIBLE);
        mCheckBox3.setVisibility(View.INVISIBLE);
        mCheckBox4.setVisibility(View.INVISIBLE);
        mSubmit.setVisibility(View.INVISIBLE);
        Cursor csr = questions.getQuestionRow(mCurrentQuestion = questions.getNextQuestionID());
        if (csr.moveToFirst()) {
            mQuestion.setText(csr.getString(csr.getColumnIndex(DBHelper.QUESTIONCOLUMN)));
            String answer1 = csr.getString(csr.getColumnIndex(DBHelper.ANSWER1COLUMN));
            String answer2 = csr.getString(csr.getColumnIndex(DBHelper.ANSWER2COLUMN));
            String answer3 = csr.getString(csr.getColumnIndex(DBHelper.ANSWER3COLUMN));
            String answer4 = csr.getString(csr.getColumnIndex(DBHelper.ANSWER4COLUMN));
            mCorrectAnswer = csr.getInt(csr.getColumnIndex(DBHelper.CORRECTCOLUMN));
            if (answer1.length() > 0) {
                mAnswer1.setText(answer1);
                mAnswer1.setVisibility(View.VISIBLE);
                mCheckBox1.setVisibility(View.VISIBLE);
            }
            if (answer2.length() > 0) {
                mAnswer2.setText(answer2);
                mAnswer2.setVisibility(View.VISIBLE);
                mCheckBox2.setVisibility(View.VISIBLE);
            }
            if (answer3.length() > 0) {
                mAnswer3.setText(answer3);
                mAnswer3.setVisibility(View.VISIBLE);
                mCheckBox3.setVisibility(View.VISIBLE);
            }
            if (answer4.length() > 0) {
                mAnswer4.setText(answer4);
                mAnswer4.setVisibility(View.VISIBLE);
                mCheckBox4.setVisibility(View.VISIBLE);
            }
        }
        csr.close();
    }

    void submitQuestion() {
        String questionresult = "Incorrect.";
        if (mCurrentAnswer == mCorrectAnswer) {
            questionresult = " Correct.";
            questions.insertProgress(mCurrentQuestion);
        }
        Toast.makeText(this,
                "Submitted Question " +
                        Long.toString(mCurrentQuestion) +
                        " Your answer was " + questionresult
                ,
                Toast.LENGTH_SHORT
        ).show();
        displayCurrentQuestion();
    }

    void setSubmitButtonListener() {
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitQuestion();
            }
        });
    }

    void setCheckBoxListeners() {
        mCheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    mCheckBox2.setChecked(false);
                    mCheckBox3.setChecked(false);
                    mCheckBox4.setChecked(false);
                    mSubmit.setVisibility(View.VISIBLE);
                    mCurrentAnswer = 1;
                }
            }
        });
        mCheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    mCheckBox1.setChecked(false);
                    mCheckBox3.setChecked(false);
                    mCheckBox4.setChecked(false);
                    mSubmit.setVisibility(View.VISIBLE);
                    mCurrentAnswer = 2;
                }
            }
        });
        mCheckBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    mCheckBox1.setChecked(false);
                    mCheckBox2.setChecked(false);
                    mCheckBox4.setChecked(false);
                    mSubmit.setVisibility(View.VISIBLE);
                    mCurrentAnswer = 3;
                }
            }
        });
        mCheckBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    mCheckBox1.setChecked(false);
                    mCheckBox2.setChecked(false);
                    mCheckBox3.setChecked(false);
                    mSubmit.setVisibility(View.VISIBLE);
                    mCurrentAnswer = 4;
                }
            }
        });
    }

    void addQuestions() {
        questions.insertQuestion("What was the name that nobody should have known?",
                1,
                "The Man with no Name.",
                "Alan Parson Ah Ha.",
                "Engelbert Humperdink.",
                "Rumplestiltskin.",
                4
        );
        questions.insertQuestion("What Band released the Album entitled Crime of the Cetury",
                2,
                "The Tramps",
                "Super Tramp",
                "Trankenstiens Feast",
                "Tranvison Vamp",
                2
        );
        questions.insertQuestion("Where is the worlds only Treacle Mine?",
                3,
                "Ginge",
                "Ardington",
                "Lockinge",
                "Peasemoore",
                1
        );
    }
}