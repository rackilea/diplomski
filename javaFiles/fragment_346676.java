public class QuestionM {

    private String mQuestion;
    private String mAnswer;
    private String mExplanation;
    private Context mContext;

    //constructor
    public QuestionM(String question,String explanation, Context context) {
        mQuestion = question;
        mExplanation = explanation;
        mContext = context;
    }

public class QuestionnaireM {

    private List<QuestionM> mQuestionsList;

    //constructor
    public QuestionnaireM(){
        mQuestionsList = new ArrayList<>();


    //when i creating object of that class android points the crush here
    String [] questions = mContext.getResources().getStringArray(R.array.test);
    String [] questionExplanations = mContext.getResources().getStringArray(R.array.test_a);
    for (int i=0; i<questions.length; i++){
        QuestionM question = new QuestionM(questions[i],questionExplanations[i]);
        mQuestionsList.add(question);
    }

}