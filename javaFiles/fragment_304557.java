private static final int mLayoutParamFlags = WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        //| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

public void onCreate() {
    super.onCreate();

    LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    mSnackbarView = layoutInflater.inflate(R.layout.activity_snackbar, null);

    WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_PARENT,
            WindowManager.LayoutParams.WRAP_PARENT,
            WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
            mLayoutParamFlags,
            PixelFormat.TRANSLUCENT);

    WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
    windowManager.addView(mSnackbarView, params);
}