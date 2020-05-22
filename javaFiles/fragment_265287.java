yourEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
@Override
 public void onFocusChange(View v, boolean hasFocus) {
    if (hasFocus) {
        //got focus
    } else {
        //lost focus
    }
  }
});