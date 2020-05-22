public class DrawerLayout extends ViewGroup {
    //..........
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = ev.getActionMasked();
        //.........
        boolean interceptForTap = false;

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX();
                final float y = ev.getY();
                if (mScrimOpacity > 0) {
                    /////////////////
                    //
                    //  take a look at: ViewDragHelper.findTopChildUnder(x, y) 
                    //  it finds child from last to first
                    //
                    /////////////////
                    final View child = mLeftDragger.findTopChildUnder((int) x, (int) y);
                    if (child != null && isContentView(child)) {
                        // if child is the contentView of DrawerLayout, intercept it
                        interceptForTap = true;
                    }
                }
                //.........
                break;
            }
            //...........
        }

        return interceptForDrag || interceptForTap || hasPeekingDrawer() || mChildrenCanceledTouch;
    }
    //...........
}