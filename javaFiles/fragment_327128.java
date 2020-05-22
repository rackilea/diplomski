public class QuestionsActivity extends AppCompatActivity implements 
    RadioGroup.OnCheckedChangeListener{
    LinkedHashMap<String,RadioGroup> questionList;
    LinkedHashMap<String,String> answerList;
    ArrayList<String> keys=new ArrayList<>();
    int keyCounter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        questionList=new LinkedHashMap<>(); //This Map contains all the questions with two radio button (options)
        answerList=new LinkedHashMap<>(); //This Map will contain question along with selected answer.

        initQuestions(); //This method will add 30 questions with options

        keys.addAll(questionList.keySet());

        showQuestions(keys.get(keyCounter));//This method will show the first question






    }

    private void showQuestions(String key) {
        TextView textView=(TextView)findViewById(R.id.tv_question);
        textView.setText(key);
        LinearLayout layout =(LinearLayout)findViewById(R.id.questionsLayout);
        layout.removeAllViews();
        RadioGroup rg=questionList.get(key);
        rg.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(rg);
        rg.setOnCheckedChangeListener(this);


    }

    private void initQuestions() {
        for (int i = 1; i <=3; i++) {
            RadioGroup rg=new RadioGroup(this);
            RadioButton rb1 =new RadioButton(this);
            rb1.setText("Q "+i+" RadioButton 1");
            RadioButton rb2 =new RadioButton(this);
            rb2.setText("Q "+i+" RadioButton 2");
            rg.addView(rb1);rg.addView(rb2);
            questionList.put("Question "+i,rg);


        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        RadioButton rb=(RadioButton) findViewById(group.getCheckedRadioButtonId());




        if(keyCounter<questionList.size()) {
            answerList.put(keys.get(keyCounter),rb.getText().toString());  // Putting the question and selected answer to 'answerList' map.
            keyCounter++;
            if(keyCounter<questionList.size()) {
                showQuestions(keys.get(keyCounter));// showing the next question.
            }

        }else {
            Toast.makeText(this, "You've answered all the questions.", Toast.LENGTH_SHORT).show();
        }

        for (String s : answerList.keySet()) {
            System.out.println("Q--> "+s+", A--> "+answerList.get(s)); // Here you can see all the questions and selected answers on your logs(AndroidMonitor).
        }
    }
    }