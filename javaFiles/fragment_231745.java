Vector2f returnCode = new Vector2f(0, 0);

    returnCode.x = (Math.abs(left) - right) * aWidth;
    returnCode.y = (Math.abs(top) - bottom) * aHeight;

    int temp = 0;

    if(returnCode.x > 0){
        //Hits left
        temp = 2;
    }else{
        //Hits right
        temp = 4;
    }

    if(returnCode.y > 0){
        //Hits top
        if(returnCode.y > Math.abs(returnCode.x)){
            temp = 1;
        }
    }else{
        //Hits bottom
        if(returnCode.y < -Math.abs(returnCode.x)){
            temp = 3;
        }
    }

    return temp;