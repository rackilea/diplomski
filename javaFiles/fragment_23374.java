// store distance between circle's axes for later (called in constructor)
 offsetX = _bone.getParentCircleX() - _bone.getChildCircleX();
offsetY = _bone.getParentCircleY() - _bone.getChildCircle();

// helper for mimicking Circle A's movement (called in updateLocation())
int diffX = e.getX() - last_x;
int diffY = e.getY() - last_y;

_cir.setChildCircleX(lastChildx - diffX - (_cir.PARENT_CIRCLE_SIZE / 2)) 
_cir.setChildCircleY(lastChildY - diffY - (_cir.PARENT_CIRCLE_SIZE / 2));


// update position and readjust for next time
lastChildx = last_x - offsetX;
lastChildy = last_y - offsetY;