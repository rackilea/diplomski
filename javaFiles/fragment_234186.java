public class MyActivity extends Activity {

    private boolean fetchedQuestions;
    private boolean fetchedAnswers;

    private JSONObject questions;
    private JSONObject answers;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        refresh();
    }

    private void refresh(){

        fetchedQuestions = false;
        fetchedAnswers = false;

        long docId = 1;

        MyApiClient.getQuestions(docId, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject questionsResponse) {
                questions = questionsResponse;  
                fetchedQuestions = true;
                if (fetchedAnswers)
                    populatePage();

            }
        });

        MyApiClient.getAnswers(docId, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject answersResponse) {
                answers = answersResponse;  
                fetchedAnswers = true;
                if (fetchedQuestions)
                    populatePage();

            }
        });
    }

    private void populatePage(){
        // do stuff with "questions" and "answers"
    }     

}