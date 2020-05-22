@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toast.makeText(searchParam.this, "onCreate called", Toast.LENGTH_LONG).show();

    //Get your precious data
    Bundle bundle = getIntent().getExtras();
    selectedSubject = bundle.getString("subject");
    priceBand = bundle.getString("priceBand");
    checked = bundle.getBoolean("isCheck");
    starRating = bundle.getFloat("rating");

    // Call all listeners
    listenerForRatingBar();
    listenerForSubject();
    listenerForSearch();
    listenerForAdvSearch();
    listenerForGeoCheck();
    listenerForPrice();

}