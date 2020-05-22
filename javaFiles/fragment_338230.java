@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_category);

        grid = (GridView) findViewById(R.id.gridViewAllItems);
        textview = (TextView) findViewById(R.id.myTextView);
        numResults = (TextView) findViewById(R.id.textView2);

        // Start your AsyncTask here ...

}