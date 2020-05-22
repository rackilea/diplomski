@Override
public void onSaveInstanceState(Bundle outState) {
  super.onSaveInstanceState(outState);
  // Save UI state changes to the savedInstanceState.
  // This bundle will be passed to onCreate if the process is
  // killed and restarted.
  savedInstanceState.putInt("GeneratedNumber", generatedNumber);// generatedNumber is integer
  // etc.
}

@Override
public void onRestoreInstanceState(Bundle savedInstanceState) {
  super.onRestoreInstanceState(savedInstanceState);
  generatedNumber = savedInstanceState.getInt("GeneratedNumber");

}

/** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    /** 
*
*  layout initailization
*/
    if (savedInstanceState != null) {
       mTextView.setText(String.valueOf(generatedNumber));
    } 

  }