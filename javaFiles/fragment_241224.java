@Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode==KeyEvent.KEYCODE_CAMERA) {
      // do something

      return(true);
    }

    return(super.onKeyDown(keyCode, event));
  }