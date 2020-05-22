swift.setOnEditorActionListener(new OnEditorActionListener() {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
              //saveChanges();
              //finish();
              Toast.makeText(getApplicationContext(), "Your changes have been saved", Toast.LENGTH_SHORT).show();
            }    
            return false;
        }
    });