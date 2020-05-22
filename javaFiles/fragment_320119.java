private int getDistanceSquaredBetweenPoints(x, y, centerX, centerY){

    // formula is: distance = sqrt( (x - cx) ^ 2 + (y - cy) ^ 2 )
    //   so, distance ^ 2 = (x - cx) ^ 2 + (y - cy) ^ 2

    return Math.pow(centerX - x, 2) + Math.pow(centerY - y, 2);
}