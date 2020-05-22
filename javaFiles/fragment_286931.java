public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    final Button searchButton = (Button) findViewById(R.id.searchButton);
    final ProgressBar searchProgress = (ProgressBar) findViewById(R.id.searchProgress);

    ViewTreeObserver vto = searchButton.getViewTreeObserver();
    vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            searchProgress.setLayoutParams(new LinearLayout.LayoutParams(searchButton.getMeasuredWidth(), searchButton.getMeasuredHeight()));
        }
    });
}