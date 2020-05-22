public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
  if(System.currentTimeMillis() - lastTap < 1000) 
    return true;

  // your character jump code

  lastTap = System.currentTimeMillis();
  return true;