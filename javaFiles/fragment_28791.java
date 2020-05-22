public abstract class OnDoubleClickListener implements View.OnClickListener {
    private final int doubleClickTimeout;
    private Handler handler;

    private long firstClickTime;

    public OnDoubleClickListener() {
        doubleClickTimeout = ViewConfiguration.getDoubleTapTimeout();
        firstClickTime = 0L;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onClick(final View v) {
        long now = System.currentTimeMillis();

        if (now - firstClickTime < doubleClickTimeout) {
            handler.removeCallbacksAndMessages(null);
            firstClickTime = 0L;
            onDoubleClick(v);
        } else {
            firstClickTime = now;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    onSingleClick(v);
                    firstClickTime = 0L;
                }
            }, doubleClickTimeout);
        }
    }

    public abstract void onDoubleClick(View v);

    public abstract void onSingleClick(View v);

    public void reset() {
        handler.removeCallbacksAndMessages(null);
    }
}