private class RecyclerViewOnGestureListener extends SimpleOnGestureListener {

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
        int position = recyclerView.getChildPosition(view);

        // handle single tap

        return super.onSingleTapConfirmed(e);
    }

    public void onLongPress(MotionEvent e) {
        View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
        int position = recyclerView.getChildPosition(view);

        // handle long press

        super.onLongPress(e);
    }
}