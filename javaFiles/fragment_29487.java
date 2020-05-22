int action = event.getActionMasked();

if (action == MotionEvent.ACTION_DOWN) {
    long[] pattern = { 0, 200, 0 }; //0 to start now, 200 to vibrate 200 ms, 0 to sleep for 0 ms.
    vibrator.vibrate(pattern, 0); // 0 to repeat endlessly.
} else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
    vibrator.cancel();
}