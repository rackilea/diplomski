for (int i = 0; i < myGrid.length; i++) {
    for (int k = 0; k < myGrid[i].length; k++) {

        Point xy = myGrid[i][k].getShapeThing();

        if (myGrid[i][k] instanceof Square) {
            Square square = (Square)myGrid[i][k];
            int w = square.getSquareThing();

        } else if (myGrid[i][k] instanceof Circle) {
            Circle circle = (Circle)myGrid[i][k];
            int d = circle.getCircleThing();
        }
    }
}