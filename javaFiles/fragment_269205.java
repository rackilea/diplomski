public boolean onKeyDown(int keyCode, KeyEvent event) {
    KeyGameEvent kge = new KeyGameEvent(keyCode, false, evt);
    eventQueue.add(kge);
    return true;
  }

  public boolean onKeyUp(int keyCode, KeyEvent event) {
    KeyGameEvent kge = new KeyGameEvent(keyCode, true, evt);
    eventQueue.add(kge);
    return true;
  }

  public void onLongPress(MotionEvent evt) {
    LongPressGestureGameEvent lpe = new LongPressGestureGameEvent(evt);
    eventQueue.add(lpe);
  }