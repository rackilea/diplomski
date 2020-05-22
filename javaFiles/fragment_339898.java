public class FlingGallery extends Gallery {
    private OnFlingListener onFlingListener;

    public FlingGallery(Context context) {
        super(context);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        boolean isConsumed = super.onFling(e1, e2, velocityX, velocityY);

        if(isConsumed) {
            if(onFlingListener != null) {
                onFlingListener.onFling(e1, e2, velocityX, velocityY);
            }
        }

        return isConsumed;
    }

    public OnFlingListener getOnFlingListener() {
        return onFlingListener;
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.onFlingListener = onFlingListener;
    }

    public static interface OnFlingListener {
        void onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);
    }