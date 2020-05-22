float angle = (float) Math.toDegrees(Math.atan2(y_2 - y_1, x_2 - x_1));

    //Take this out if you want negative values.
    if(angle < 0){
        angle += 360;
    }