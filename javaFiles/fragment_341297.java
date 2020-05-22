private static final int SWIPE_MIN_DISTANCE = 120;
private static final int SWIPE_MAX_OFF_PATH = 250;
private static final int SWIPE_THRESHOLD_VELOCITY = 100;
@Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
            float velocityY) {
        Log.d("---onFling---", e1.toString() + e2.toString() + "");

        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;
            // right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                //do your code

            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                //left to right flip
                }
            }
        } catch (Exception e) {
            // nothing
        }
        return false;
    }