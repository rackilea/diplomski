int eastWest = Double.compare(currentPoint.getX(), nextPoint.getX()) 
if (eastWest == 0) {
    int northSouth = Double.compare(currentPoint.getX() , nextPoint.getX()) 
    /* DRIVE NORTH (-1), SOUTH (+1) */ 
    if (northSouth == 0)
       rotation = -1;
    else
       rotation = (5 + northSouth - heading) % 4;
} else {
    /* DRIVE WEST (-1), EAST (+1) */  
    rotation = heading ^ (2 + eastWest);
}