// init your variable only
Button button;

// Then in onCreate, as you already did:
@Override
protected void onCreate(Bundle savedInstanceState) {
    // ...
    // set findViewById method only here
    button = (Button) findViewById(R.id.button1);  
    // ...
}