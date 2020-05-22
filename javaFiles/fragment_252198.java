public void render(float delta)
 {
   stateTime += delta;
   currentFrame = walkAnimation.getKeyFrame(stateTime, true);  
   // Then render the frame as follows
   batch.draw(currentFrame, x, y, (float)85, (float)85, (float)170, (float)170, (float)1, (float)1, (float)angleDegrees + 270);
 }