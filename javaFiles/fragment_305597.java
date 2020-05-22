private void checkForNextCollision() {
    double boundsWidth = width + dX ;
    if(dX < 0){
        boundsWidth= width - dX ;
    }

    double boundsHeight = height + dY ;
    if(dY < 0){
        boundsHeight = height - dY ;
    }
    double boundx = xWorld + dX ;
    double boundy = yWorld + dY ;
    betweenRect = new Rectangle((int)(boundx),(int)(boundy),(int)(boundsWidth), (int)(boundsHeight));


}