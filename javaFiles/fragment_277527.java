for (int i = 0, n = activeAnimations.size; i < n; i++) {
    MyAnimation animation = activeAnimations.get(i);
    float x = heroX + animation.getXOffset();
    float y = heroY + animation.getYOffset();
    //... retrieve all other parameters, and use them to draw the animation
    //animation stateTime and frameDuration are the same for all of the animations
}