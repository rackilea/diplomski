int lastX;
int lastY;
Scroller scroller;    
@Override
public void computeScroll() {
  if (scroller.computeScrollOffset()) {
    if (!scrolledLastFrame) {
      lastX = scroller.getStartX();
      lastY = scroller.getStartY();
    }

    int dx = scroller.getCurrX() - lastX;
    int dy = scroller.getCurrY() - lastY;

    lastX = scroller.getCurrX();
    lastY = scroller.getCurrY();

    doScroll(dx, dy);
    scrolledLastFrame = true;
  } else {
    scrolledLastFrame = false;
  }

}    

public void doFling(int startX, int startY, int velocityX, int velocityY,
    int minX, int maxX, int minY, int maxY) {
  scroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
  invalidate();
}

public void doScroll(int dx, int dy) {
  currentX+=dx;
  currentY+=dy;

  invalidate();
}

private class ProgramGestureListener extends SimpleOnGestureListener {

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
        float distanceX, float distanceY) {

      doScroll(distanceX, distanceY);
      return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
      int max_left = getMaxHorizontalScroll();
      int max_top = getMaxVerticalScroll();
      int min_left = getMinHorizontalScroll();
      int min_top = getMinVerticalScroll();

      int startX = getCurrentHorizontalScroll();
      int startY = getCurrentVerticalScroll();

      doFling(startX, startY, (int) -velocityX, (int) -velocityY,
          min_left, max_left, min_top, max_top);

      return true;
    }
  }