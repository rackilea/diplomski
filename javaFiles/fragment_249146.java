public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDBHlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHlpr = new DatabaseHelper(this,"blah blah blah", null,1);
        QuestionBasics myQuestion = new QuestionBasics(
                "What is note X?",
                "It's not a note",
                "A note that only xylophones can make.",
                "A note when a bowed instrument is played with two bows",
                "A synthesised x wave","Something Esle",
                "Wierdness");


        mDBHlpr.addQuestionsBasics(myQuestion); //<<<<<<<<<< ADD another question

        List<QuestionBasics> mylist =  mDBHlpr.getAllQuestions1(DatabaseHelper.TABLE_QUEST1,"doesnotmatter");
        for (QuestionBasics q: mylist) {
            Log.d("QUESTIONS",q.getQUESTION1());
        }
    }
}