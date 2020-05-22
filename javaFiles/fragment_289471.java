@Override
  public boolean onKeyDown(int keyCode, KeyEvent event)
  {
      if ((keyCode == KeyEvent.KEYCODE_BACK))
      {
          finish();
      return true; // you missed this line
      }
      return super.onKeyDown(keyCode, event);
  }