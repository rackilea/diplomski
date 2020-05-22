public class EconFragment extends SherlockFragment {

    private TableLayout questionContainer;
    int pos = 0;
    private String[] titles = {"The first title ", "hallo1","hallo2", "hallo3",
            "hallo4", "hallo5","hallo6", "hallo7","hallo8", "hallo9"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("Econ", "onCreateView");
        View v = inflater.inflate(R.layout.econfragment, container, false);
        questionContainer = (TableLayout) v.findViewById(R.id.questionContainer);
        //bs
        int leftMargin=5;
        int topMargin=5;
        int rightMargin=5;
        int bottomMargin=5;
        while (pos < 10) {
        View question = inflater.inflate(R.layout.question, null);
        question.setId(pos);
        TextView title = (TextView) question.findViewById(R.id.questionTextView);
        title.setText(titles[pos]);
        Button charts = (Button) question.findViewById(R.id.chartsButton);
        charts.setId(pos);
        charts.setOnClickListener(chartsListener);
        TableRow tr = (TableRow) question;
        TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT);
        trParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
        tr.setLayoutParams(trParams);
        Log.v("econ", "while loop");
        questionContainer.addView(tr);
        pos++;
        }
        pos = 0;
        return v;
    }