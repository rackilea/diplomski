public void newPoint(int x, int y) /*throws InvalidPointException*/{
    clearPoints();
    //clear the points on the bitmap

    updateBitmapDisplay();
    //update the bitmap with the new points

    addPoint(x, y);
    //add the point to the bitmap

    updateBitmapDisplay();
    //update the bitmap with new points
}