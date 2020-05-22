Keyboard.Key key = findKey(myKeyboard, keyCode);
key.icon = myDrawable;

private Keyboard.Key findKey(Keyboard keyboard, int primaryCode) {
  for (Keyboard.Key key : keyboard.getKeys()) {
    if (key.codes[0] == primaryCode) {
      return key;
    }
  }
  return null;
}