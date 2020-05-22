@Override
public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
    detector.onTouchEvent(e);
    return false;
}

@Override
public void onTouchEvent(RecyclerView rv, MotionEvent e) {
}