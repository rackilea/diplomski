@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Get the view from listview_main.xml
    setContentView(R.layout.activity_search);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.searchUserTextField);
    textView.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            if (count % 2 == 1) {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        textView.showDropDown();
                        UserSuggestionQuery(textView);
                    }
                }, 1000);
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            UserSuggestionQuery(textView);
        }

        public void afterTextChanged(Editable s) {
            UserSuggestionQuery(textView);
        }
    });
    textView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> adapterview, View v,
                                   int position, long arg3) {
            // TODO Auto-generated method stub
            AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.searchUserTextField);
            textView.setText(adapterview.getItemAtPosition(position)
                    .toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    });
    textView.setOnTouchListener(new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent event){
            UserSuggestionQuery(textView);
            return false;
        }
    });

    SubmitSearch();

    // Execute RemoteDataTask AsyncTask
    new RemoteDataTask().execute();

}