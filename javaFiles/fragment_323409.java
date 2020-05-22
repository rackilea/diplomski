public void onKeyPressed(KeyEvent event) {
      double change = 10.0;
      if(event.isShiftDown()) { change = 50.0; }
      KeyCode keycode = event.getCode();
      ...
 }