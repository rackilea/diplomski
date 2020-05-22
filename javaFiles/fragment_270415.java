public static final String TAG = "MyActivity";
public static final String DATA_KEY = "DataKey";
public static final String MY_CUSTOM_ACTION = "MyCustomSearchAction";

public void onCreate(Bundle savedInstanceState) {
    Intent intent1 = getIntent();
    SimpleSearch SSearch = new SimpleSearch();
    if (intent1.getAction().equals(MY_CUSTOM_ACTION) 
          && intent1.hasExtra(SearchManager.QUERY)
          && intent.hasExtra(DATA_KEY)) {
        String query = intent1.getStringExtra(SearchManager.QUERY);
        DataObject data = intent1.getParcelableExtra(DATA_KEY);   
        if (query != null && data != null)
            SSearch.testSearch(query, data);
        else {
            //invalid query
           Log.d(TAG,"Activity started with invalid query data - closing");
           this.finish();
           return;
        }
    } else {
       //Invalid Intent
       Log.d(TAG,"Activity started with invalid intent - closing");
       this.finish();
       return;
    }
}