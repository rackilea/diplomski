private int mLastChildIndex = -1;

public boolean onTouch(View view, MotionEvent event) {
    int x = (int) event.getRawX();
    int y = (int) event.getRawY();

    switch(event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            mLastChildIndex = getChildIndex((ViewGroup) view, x, y);
            playNotificationForIndex(mLastChildIndex);
            break;
        case MotionEvent.ACTION_MOVE:
            int currentIndex = getChildIndex((ViewGroup) view, x, y);
            if (currentIndex != mLastChildIndex) {
                playNotificationForIndex(currentIndex);
                mLastChildIndex = currentIndex;
            } break;
        case MotionEvent.ACTION_UP:
            performClickForIndex(mLastChildIndex);
            mLastChildIndex = -1;
            break;
    }

    return true; // This method eats all MotionEvent actions for the View
}

private int getChildIndex(ViewGroup viewGroup, int x, int y) {
    for (int i = 0; i < viewGroup.getChildCount(); i++) {
        View child = viewGroup.getChildAt(i);

        int[] coordinates = new int[2];
        child.getLocationOnScreen(coordinates);

        Rect bounds = new Rect(coordinates[0], coordinates[1],
                coordinates[0] + child.getWidth(), coordinates[1] + child.getHeight());
        if (bounds.contains(x, y)) {
            return i;
        }
    } return -1;
}