public int brickSpecialAction(Brick brickie) {

    int totalRemovedBricks = 0; // Used to calculate the total number of removed bricks
    if (!this.isVisible)    //Or whatever you can check to see if you have set this invisible already
        return;             // You've already executed on this block
    this.setVisible(false); // Making it invisible