@Override
public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            float x = event.getX();
            float y = event.getY();
            if(getColourOfThePixel(x, y)){
                // DO SOMETHING
            }
    }
    return super.onTouchEvent(event);
}

public boolean getColourOfThePixel(float x, float y){
    int colorXY = mBitmap.getPixel(rangeX, rangeY);

    int r = Color.red(colorXY);
    int g = Color.green(colorXY);
    int b = Color.blue(colorXY);

    if (isYellow(r, g, b)) {
        return true;
    }
    return false;
}

public boolean isYellow(int r, int g, int b){
    // CHECK THE RANGE OF YELLOW COLOUR
}