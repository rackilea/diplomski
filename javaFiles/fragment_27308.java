while(Keyboard.next()) {
  if(Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
    if(Keyboard.getEventKeyState()) {
      Mouse.setGrabbed(!Mouse.isGrabbed());
      Mouse.setCursorPosition(Display.getWidth()/2, Display.getHeight()/2);
}}}

if(Mouse.isGrabbed()) {
//Use mouse for moving
} else {
//Use mouse for interface
}