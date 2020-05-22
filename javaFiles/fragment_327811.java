if (mousePoint != null) {
    // This represents the anchor point, in this case, 
    // the centre of the component...
    int x = width / 2;
    int y = height / 2;

    // This is the difference between the anchor point
    // and the mouse.  Its important that this is done
    // within the local coordinate space of the component,
    // this means either the MouseMotionListener needs to
    // be registered to the component itself (preferably)
    // or the mouse coordinates need to be converted into
    // local coordinate space
    int deltaX = mousePoint.x - x;
    int deltaY = mousePoint.y - y;

    // Calculate the angle...
    // This is our "0" or start angle..
    rotation = -Math.atan2(deltaX, deltaY);
    rotation = Math.toDegrees(rotation) + 180;
}