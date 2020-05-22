protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mainFlipper = (ViewFlipper) findViewById(R.id.flipper);
    firstLayout = (LinearLayout) findViewById(R.id.layout1);
    secondLayout = (LinearLayout) findViewById(R.id.layout2);


    findViewById(R.id.btnPrevious).setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            showPrevious();
        }
    });

    findViewById(R.id.btnNext).setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            showNext();
        }
    });

}

private void showNext() {
    mainFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_left));
    mainFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_right));
    flip();
}

private void showPrevious() {
    mainFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_right));
    mainFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_left));
    flip();
}

private void flip() {
    if(isFirstVisible) {
        isFirstVisible = false;
        secondLayout.removeAllViews();
        secondLayout.addView(getTextView("Second"));
    } else {
        isFirstVisible = true;
        firstLayout.removeAllViews();
        firstLayout.addView(getTextView("First"));
    }
    mainFlipper.showNext();
}

private TextView getTextView(String txt) {
    TextView txtView = new TextView(this);
    txtView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    txtView.setText(txt);
    return txtView;
}