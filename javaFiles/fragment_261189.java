....
case (MotionEvent.ACTION_UP) :
    View[] cArrayOfPossibileViews = new View[]{ findViewById(IMAGE_1), findViewById(IMAGE2) }
    getDroppedView(v, event.getRawX(), event.getRawY(), cArrayOfPossibileViews);
    break;
}
....

@Nullable
private View getDroppedView(View view, int x, int y, View[] arrayOfPossibilities) {
    Rect cVisibleBoundsRect = new Rect();
    for (View cView : arrayOfPossibilities) {
        if (!cView.getGlobalVisibleRect(cVisibleBoundsRect)) continue;
        if (cVisibleBoundsRect.contains(x, y)) {
            //THIS "cView" IS THE VIEW WHERE YOU RELEASED THE FINGER
            return cView;
        }
    }
    return null;
}