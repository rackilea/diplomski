public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "fonts/myKoreanFont.ttf");      // that's how you load your font
    TextView myTextView = (TextView) findViewById(R.id.myKoreanText);
    myTextView.setTypeface(myTypeFace);        // that's how you use your font
}