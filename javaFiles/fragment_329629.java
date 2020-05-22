public boolean checkCollision(Position newhead) {
    //To check whether newHead is collided to body, and if it occurs returns true
    for (int i = 0; i < getBodyLength(); i++) {
        if (newhead.x == body.get(i).x && newhead.y == body.get(i).y) {
            return true;
        }
    }
   //To check whether newHead is collided to wall, and if it occurs return true
   if( newhead.x == wallL.x|| newhead.x == wallL.y || newhead.y == wallR.x || newhead.y == wallR.y)
return true;
    return false;
}