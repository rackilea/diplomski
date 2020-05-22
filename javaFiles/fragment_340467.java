private Handler handler = new Handler() {
@Override
public void handleMessage(Message msg) {
    super.handleMessage(msg);
    progress.setProgress(progress.getProgress() + 100);
    if (mBooleanIsPressed)
        sendEmptyMessageDelayed(0, 100);
}
};
private Runnable runnable = new Runnable() {
public void run() {
    playAlarm();
}
};

...

progress = (ProgressBar) findViewById(R.id.progressBar1);

...

@Override
public boolean onTouchEvent(MotionEvent e) {
// only start your handler if the view isn't touched
if (e.getAction() == MotionEvent.ACTION_DOWN && !mBooleanIsPressed) {
    // Execute Runnable after 5000 milliseconds = 5 seconds.
    progress.setProgress(0);
    handler.postDelayed(runnable, 5000);
    // send the first empty message, which will be handled...
    sendEmptyMessageDelayed(0, 100);
    mBooleanIsPressed = true;
}

if (e.getAction() == MotionEvent.ACTION_UP) {
    if (mBooleanIsPressed) {
        mBooleanIsPressed = false;
        progress.setProgress(0);
        handler.removeCallbacks(runnable);
    }
}
return true;
}