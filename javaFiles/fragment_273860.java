public void setCenter(int index) {

    ViewGroup parent = (ViewGroup) getChildAt(0);

    View preView = parent.getChildAt(prevIndex);
    //preView.setBackgroundColor(Color.parseColor("#64CBD8"));
    android.widget.LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
    lp.setMargins(5, 0, 5, 0);
    preView.setLayoutParams(lp);

    View view = parent.getChildAt(index);
    //view.setBackgroundColor(Color.RED);

    int screenWidth = ((Activity) context).getWindowManager()
            .getDefaultDisplay().getWidth();

    int scrollX = (view.getLeft() - (screenWidth / 2))
            + (view.getWidth() / 2);
    this.smoothScrollTo(scrollX, 0);
    prevIndex = index;
    Log.d("ITEM", String.valueOf(prevIndex));
}

@Override
public boolean onDown(MotionEvent e) {
    // TODO Auto-generated method stub
    return false;
}

@Override
public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
        float velocityY) {
    if (flingDisable)
        return false;
    boolean returnValue = false;
    float ptx1 = 0, ptx2 = 0;
    if (e1 == null || e2 == null)
        return false;
    ptx1 = e1.getX();
    ptx2 = e2.getX();
    // right to left

    if (ptx1 - ptx2 > SWIPE_MIN_DISTANCE
            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
        if (activeItem < maxItem - 1)
            activeItem = activeItem + 1;

        returnValue = true;

    } else if (ptx2 - ptx1 > SWIPE_MIN_DISTANCE
            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
        if (activeItem > 0)
            activeItem = activeItem - 1;

        returnValue = true;
    }
    //scrollTo = activeItem * itemWidth;
    //this.smoothScrollTo(0, scrollTo);
    setCenter(activeItem);
    return returnValue;
}



@Override
public boolean onTouch(View v, MotionEvent event) {
    if (gestureDetector.onTouchEvent(event)) {
        return true;
    }
    Boolean returnValue = gestureDetector.onTouchEvent(event);

    int x = (int) event.getRawX();

    switch (event.getAction()) {
    case MotionEvent.ACTION_MOVE:
        if (start) {
            this.prevScrollX = x;
            start = false;
        }
        break;
    case MotionEvent.ACTION_UP:
        start = true;
        this.currentScrollX = x;
        int minFactor = itemWidth / SWIPE_PAGE_ON_FACTOR;

        if ((this.prevScrollX - this.currentScrollX) > minFactor) {
            if (activeItem < maxItem - 1)
                activeItem = activeItem + 1;

        } else if ((this.currentScrollX - this.prevScrollX) > minFactor) {
            if (activeItem > 0)
                activeItem = activeItem - 1;
        }
        Log.d("ITEM", String.valueOf(activeItem));
        setCenter(activeItem);
        returnValue = true;
        break;
    }
    return returnValue;
}