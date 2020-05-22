@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // Check which request we're responding to
    if (requestCode == 101) {
        // Make sure the request was successful
        if (resultCode == RESULT_OK) {
           //here get the selected id using
           int colorID = data.getIntExtra("SELECTED_COLOR", 0);
          //use it to set the background here
        }
    }
}