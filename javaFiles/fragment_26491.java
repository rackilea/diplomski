ratingBar.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            float touchPositionX = event.getX();
            float width = ratingBar.getWidth();
            float starsf = (touchPositionX / width) * 5.0f;
            starRate = (int) starsf + 1;
            ratingBar.setRating(starRate);
            promptSubmitStar();
        }
        return true;
    }
});