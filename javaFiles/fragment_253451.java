public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
  if(player.b2body.getLinearVelocity().y > 3.5f) 
    return true;

    // your character jump code

    return true;
}