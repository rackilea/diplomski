public class MyActivity extends FragmentActivity {

static ArrayList<MyQuestion> myQuestions = new ArrayList<MyQuestion>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (myQuestions.isEmpty()) {
        addQuestionAndAnswer();
    }

}

private void addQuestionAndAnswer() {
    // here add your question and answer
}