@Override
public void onBackPressed() {
    NavUtils.navigateUpFromSameTask(this); 
    // Otherwise defer to system default behavior.
    super.onBackPressed(); 
}