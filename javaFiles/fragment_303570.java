@Override
 public boolean onKeyDown(int keyCode, KeyEvent event) {
       if ((keyCode == KeyEvent.KEYCODE_BACK)) {
        //YOUR CODE HERE
    finish(); //<<<------MUST BE USED SO THAT THE BUTTON WILL ACTUALLY FINISH THE APP
        }
  return super.onKeyDown(keyCode, event);
   }