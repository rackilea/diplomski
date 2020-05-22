if (event.getPointerCount() > 1) {
    //MULTI TOUCH EVENT IS TRIGGERED!
    // The coordinates of the current screen contact, relative to 
    // the responding View or Activity.  
    xPos = (int)MotionEventCompat.getX(event, index);
    yPos = (int)MotionEventCompat.getY(event, index);

} else {
    // Single touch event

    xPos = (int)MotionEventCompat.getX(event, index);
    yPos = (int)MotionEventCompat.getY(event, index);
}