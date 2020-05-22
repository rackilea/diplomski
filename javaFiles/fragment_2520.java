public boolean ccTouchesEnded(MotionEvent event) {

    touchTapCount++;
    Lg("Tapcount : " + touchTapCount);
    if (touchTapCount == 1) {
        // Very important bit of code..
        // First, we define a Handler and a Runnable to go with it..
        Handler handler = new Handler(Looper.getMainLooper());
        final Runnable r = new Runnable() {
            public void run() {
                // In the runnable, we set the touchTapCount back to 0..
                touchTapCount = 0;
            }
        };
        // Now, execute this handler with a delay of 200ms..
        handler.postDelayed(r, 200);

    } else {
        if (touchTapCount == 2){
            wasdoubletapped = true;
            verifySelectorTypeBeforeRotate(cC, cR, SELECTOR_CROSS);
        }