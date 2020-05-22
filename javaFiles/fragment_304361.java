@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main3);

    Button b = (Button) findViewById(R.id.button5);
    b.setVisibility(View.GONE);

    visibleButton(b);



}

private void visibleButton(final View view){

    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            view.setVisibility(View.VISIBLE);
        }
    }, 1000 * 3);

  }
}