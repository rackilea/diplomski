public class SlidingPaneLayoutExtended extends SlidingPaneLayout {

public static final int DEFAULT_DRAGGING_START_X = -1;
public static final int SLIDE_FROM_LEFT_EDGE = 0;

private int startDraggingX = DEFAULT_DRAGGING_START_X;

public SlidingPaneLayoutExtended(Context context, AttributeSet attrs) {
    super(context, attrs);
}


public int getStartDraggingX() {
    return startDraggingX;
}

public void setStartDraggingX(int startX) {
    this.startDraggingX = startX;
}

@Override
public boolean onTouchEvent(MotionEvent ev) {

    if (startDraggingX > DEFAULT_DRAGGING_START_X) {
        if ((startDraggingX == SLIDE_FROM_LEFT_EDGE && ev.getAction() == )
                || ev.getX() <= DEFAULT_DRAGGING_START_X) {
            return super.onTouchEvent(ev);
        } else {
            return false;
        }
    }

    return super.onTouchEvent(ev);
}
}