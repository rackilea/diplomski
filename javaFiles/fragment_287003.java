@Override
public void onResume() {
    super.onResume();  // Always call the superclass method first
    if(myBackgroundColor!=null){
        ConstraintLayout mainAcBackground = (ConstraintLayout) findViewById(R.id.mainAcBackground);
        mainAcBackground.setBackgroundColor(myBackgroundColor);
    }
}