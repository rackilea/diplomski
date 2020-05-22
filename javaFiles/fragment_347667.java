public boolean fling(float velocityX, float velocityY, int button) {
    if(Math.abs(velocityX)>Math.abs(velocityY)){
        if(velocityX>0){
                directionListener.onRight(velocityX);
                //System.out.println(""+velocityX);
        }else{
                directionListener.onLeft(velocityX);
                //System.out.println(""+velocityX);
        }
    }else{
        if(velocityY>0){
                directionListener.onDown(velocityY);
        }else{                                  
                directionListener.onUp(velocityY);
        }
    }

    //Both x and y have velocity != 0 so it is moving on the diagonal
    if ((velocityX != 0) && (velocityY != 0)){
            directionListener.onDiagonal(velocityX, velocityY);
    }

    return super.fling(velocityX, velocityY, button);
}