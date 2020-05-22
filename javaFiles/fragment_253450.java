public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
  // the limit is reached
  if(jumps == maxJumps) 
    return true;

  // your character jump code

  jumps++;
  return true;