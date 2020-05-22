public class Example {
    private ArrayList<String> questionid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {        
        questionid = new ArrayList<String>();
        questionid.add("1");
        ...
    }

    private void newQuestion() {
        String firstQuestion = questionid.get(0);
        ...
    }
}