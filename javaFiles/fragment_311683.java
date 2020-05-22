protected boolean keyChar(char c, int status, int time) {
  if (c == Characters.ESCAPE) {
     // do nothing if ESC was pressed
     return true;
  } else {
     // accept the default behaviour for other keys
     return super.keyChar(c, status, time);
  }
}