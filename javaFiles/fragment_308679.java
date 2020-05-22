class BouncingBall{
    public void horizontalFlip(){
        moveX *= -1;
    }

    public void verticalFlip(){
        moveY *= -1;
    }

    //To have move control over each direction, you can have a method for each direction.
    public void moveNorth(){
        moveY = Math.abs(moveY) * -1;
    }

    public void moveSouth(){
        moveY = Math.abs(moveY);
    }

    public void moveWest(){
        moveX = Math.abs(moveX) * -1;
    }

    public void mpveEast(){
        moveX = Math.abs(moveX);
    }
}