public class OverlayService extends Service {

    private WindowManager windowManager;
    private View layout;

    @Override
    public void onCreate() {
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_PHONE,
            // very important, this sends toush events to underlying views
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, 
            PixelFormat.TRANSLUCENT);
        // Layout gravity
        params.gravity = Gravity.TOP | Gravity.CENTER;
        params.x = 0; params.y = 100;

        LayoutInflater li = (LayoutInflater) getApplicationContext()
             .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Your overlay layout
        layout = li.inflate(R.layout.overlay, null;

        // This displays overlay on the screen
        windowManager.addView(layout, params);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Error will occur if this is missing.
        if (layout != null)
            windowManager.removeView(layout);
    }
}