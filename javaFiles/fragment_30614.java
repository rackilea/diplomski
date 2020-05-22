private ScrollView _scrollView;

private Runnable _smoothScrollRunnable = new Runnable() {
    @Override
    public void run() {
        _scrollView.smoothScrollBy(2, 2);

        if (_scrollView.canScrollVertically(1)) {
            _scrollView.postDelayed(_smoothScrollRunnable, 75);
        }
    }
};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    _scrollView = (ScrollView) findViewById(R.id.scrollview);
}

@Override
protected void onResume() {
    super.onResume();

    _scrollView.post(_smoothScrollRunnable);
}