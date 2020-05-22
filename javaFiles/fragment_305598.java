public void collide(Sprite s, int maxX, int maxY) {
    maxWX = maxX;
    maxWY = maxY;


    //check for collision with borders
    if (xWorld <= 0) {
        dX = -dX;
        xWorld += 2;
        if(xWorld < -1000){
            dX = 0;
            xWorld += 10;
        }
    }
    if (yWorld <= 0) {
        dY = -dY;
        yWorld += 2;
        if(yWorld < -1000){
            dX = 0;
            yWorld += 10;
        }
    }
    if (xWorld + width >= maxX) {
        dX = -dX;
        xWorld -= 2;
        if(xWorld+width > maxX + 1000){
            dX = 0;
            xWorld -= 10;
        }
    }
    if (yWorld + height >= maxY) {
        dY = -dY;
        yWorld -= 2;
        if(yWorld+height > maxY + 1000){
            dY = 0;
            yWorld -= 10;
        }
    }



    //check for collision with borders
    if(betweenRect.intersects(s.betweenRect)){
        willIntersect = true;
    }else{
        willIntersect = false;
    }

    // Use all checks to see if they should collide
    if (getRect().intersects(s.getRect()) || s.getRect().intersects(getRect()) || willIntersect || (xWorld + width > s.xWorld && xWorld < s.xWorld + s.width && yWorld < s.yWorld+s.height && yWorld + height > s.yWorld) ) {

            double lastDy = dY;
            double lastsDy = s.dY;
            double lastDx = dX;
            double lastsDx = s.dX;

            dY = (((weight - s.weight) / (weight + s.weight)) * lastDy)
                    + (((2.0 * s.weight) / (weight + s.weight)) * lastsDy);
            s.dY = (((s.weight - weight) / (weight + s.weight)) * lastsDy)
                    + (((2.0 * weight) / (weight + s.weight)) * lastDy);

            dX = (((weight - s.weight) / (weight + s.weight)) * lastDx)
                    + (((2.0 * s.weight) / (weight + s.weight)) * lastsDx);
            s.dX = (((s.weight - weight) / (weight + s.weight)) * lastsDx)
                    + (((2.0 * weight) / (weight + s.weight)) * lastDx);



            if(willIntersect){
                willIntersect = false;
                //s.willIntersect = false;
            }


        }




}