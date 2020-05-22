//Grab the current touch coordinates
    float x = event.getX();
    float y = event.getY();

    //If you only want something to happen then the user touches down...
    if (event.getAction() != MotionEvent.ACTION_UP) return true;

    //If the user pressed in the following area, run it's associated method
    if (isXYInRect(x, y, new Rect(x1, y1, x2, y2)))
    {
        //Do whatever you want for your defined area
    }
    //or, if the user pressed in the following area, run it's associated method
    else if (isXYInRect(x, y, new Rect(x1, y1, x2, y2)))
    {
        //Do whatever you want for your defined area
    }