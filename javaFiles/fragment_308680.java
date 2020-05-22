if(b1.intersects(b2)){
    if(b1.getX() < b2.getX()){ // b1 above b2
        b1.moveNorth();
        b2.moveSouth();
    }
    else{
        b1.moveSouth();
        b2.moveNorth();
    }
   if(b1.getY() < b2.getY()){ // b1 at left side of b2
        b1.moveWest();
        b2.moveEast();
    }
    else{
        b1.moveEast();
        b2.moveWest();
    }
}