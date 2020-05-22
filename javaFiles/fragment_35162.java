private OnKeyListener etOnKeyListener = new OnKeyListener() {
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        // if the event is a key-down event on the enter button
        if ((event.getAction() == KeyEvent.ACTION_DOWN) && 
                (keyCode == KeyEvent.KEYCODE_ENTER)) 
        {
            // get the EditText that this listener is set on
            EditText editTextWithListener = (EditText)v;

            // now you will get the text from the EditText where you are listening to even if you
            // change the reference as above
            Toast.makeText(WebViewMain.this, editTextWithListener.getText() ,Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
};