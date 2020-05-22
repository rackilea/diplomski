public boolean dispatchKeyEvent(KeyEvent event) {
    if (event == null || event.getAction() == KeyEvent.ACTION_UP) {

        return false;
    }
   if(event.getKeyCode() == KeyEvent.KEYCODE_DEL){

    mEntry.setOnFocusChangeListener(new OnFocusChangeListener(){

        public void onFocusChange(View v,boolean hasFocus){

              if (!hasFocus && !mEntry.getText().toString().trim().equals("")) {

                    mSession.appendToEmulator(cmdLeft, 0, cmdLeft.length);
                    mSession.appendToEmulator(cmdErase, 0, cmdErase.length);

              }
              else 
              {
                    mEntry.setText(" ");
              }
        }          
    });

    try {
        sendOverSerial("\b".getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
}

    return super.dispatchKeyEvent(event);
};