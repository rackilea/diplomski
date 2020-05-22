@Override
protected int getChildDrawingOrder (int childCount, int i) {
    int centerChild = 0;
    //find center row
    if ((childCount % 2) == 0) { //even childCount number
        centerChild = childCount / 2; // if childCount 8 (actualy 0 - 7), then 4 and 4-1 = 3 is in centre.      
        int otherCenterChild = centerChild - 1;
        //Which more in center?
        View child = this.getChildAt(centerChild);
        final int top = child.getTop();
        final int bottom = child.getBottom();
        //if this row goes through center then this
        final int absParentCenterY = getTop() + getHeight() / 2;
        //Log.i("even", i + " from " + (childCount - 1) + ", while centerChild = " + centerChild);
        if ((top < absParentCenterY) && (bottom > absParentCenterY)) {
            //this child is in center line, so it is last
            //centerChild is in center, no need to change
        } else {
            centerChild = otherCenterChild;
        }
    }
    else {//not even - done
        centerChild = childCount / 2;
        //Log.i("not even", i + " from " + (childCount - 1) + ", while centerChild = " + centerChild);
    }

    int rez = i;
    //find drawIndex by centerChild
    if (i > centerChild) {
        //below center
        rez = (childCount - 1) - i + centerChild;
    } else if (i == centerChild) {
        //center row
        //draw it last
        rez = childCount - 1;
    } else {
        //above center - draw as always
        // i < centerChild
        rez = i;
    }
    //Log.i("return", "" + rez);
    return rez;

}