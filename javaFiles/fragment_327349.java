public boolean onOptionsItemSelected (MenuItem item) {
    if (textView.getText().trim().equals("")){
        // show the message dialog
        return true;
    }
    else {
        // we have some message. We can let android know that
        // it is safe to fire the intent.
        return false;
    }
}