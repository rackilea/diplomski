boolean leftleftRectBool = false,rightRectBool = false;
long scanningTimeRight =  System.currentTimeMillis()+3000;
long scanningTimeLeft =  System.currentTimeMillis()+3000;

camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
    if(Gdx.input.isTouched())
    {
        if (leftThumbRectangle.contains(touchPoint.x, touchPoint.y)) {
                    if (scanningTime > System.currentTimeMillis()) {
                leftRectBool = false;
                scanningTimeStart = true;
            } else {
                scanningTimeRight = System.currentTimeMillis()+3000;
                scanningTimeStart = false;
                leftRectBool = true;
                   }

             }
if(rightThumbRectangle.contains(touchPoint.x, touchPoint.y)) {
                       if (scanningTime > System.currentTimeMillis()) {
                rightRectBool = false;
                scanningTimeStart = true;
            } else {
                scanningTimeLeft = System.currentTimeMillis()+3000;
                scanningTimeStart = false;
                rightRectBool = true;
                   }
}

else {

        scanningTimeRight = System.currentTimeMillis() + 3000;
        scanningTimeLeft = System.currentTimeMillis()+3000;
     }
           if(lefttRectBool && lefttRectBool)
             {
              // some thing happen
             }