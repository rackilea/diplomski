@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main3);

    Button b = (Button) findViewById(R.id.btn);


    invisibleButton(b);

}

private void invisibleButton(final View view){

    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            view.setVisibility(View.GONE);
        }
    }, 1000 * 3);

  }
}