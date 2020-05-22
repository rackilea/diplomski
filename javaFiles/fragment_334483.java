public class MainActivity extends ActionBarActivity implements BringBackListener {

    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------

    private TextView mResultTextView;

    // ----------------------------------
    // LYFECYCLE
    // ----------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTextView = (TextView) findViewById(R.id.resultTextView);
        LinearLayout li = (LinearLayout) findViewById(R.id.canvasLayout);

        MyBringBack pcc = new MyBringBack(this);
        li.addView(pcc);

        // Do not forget to set the listener (here it is the MainActivity 
        // since it implements BringBackListener)
        pcc.setBringBackListener(this);
    }

    // ----------------------------------
    // IMPLEMENTED METHODS
    // ----------------------------------

    @Override
    public void onObservableValueChanged(int value) {
        mResultTextView.setText(value + "");
    }
}