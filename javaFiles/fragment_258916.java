@Override
protected void onCreate(Bundle savedInstanceState) {
    //After buttons being declared
    current = 0;
    btnBack.setEnabled(false);
    btnNext.setEnabled(true);
    String randomSaying = (sayings[current]);
    sayingsTextView.setText('"' + randomSaying + '"');
    resId = sayingsResIds.get(randomSaying);
    sayingsTextView.startAnimation(anim); 
    //Rest of your code
}