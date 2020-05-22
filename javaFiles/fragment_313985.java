if (animating) {
    stateTime+=delta;
    TextureRegion currentFrame = myAnim.getKeyFrame(stateTime);
    // draw the currentFrame
    if(myAnim. isAnimationFinished(stateTime)) {
        animating = false;
        stateTime = 0;
    }
}
else {
   // draw the unanimated Frame;
}