void showOverlay(){
LayoutInflater inflater = activity.getLayoutInflater();
layout = inflater.inflate(R.layout.overlay_layout, null);
WindowManager.LayoutParams params = new WindowManager.LayoutParams();
params.gravity = Gravity.BOTTOM;
params.height = WindowManager.LayoutParams.WRAP_CONTENT;
params.width = WindowManager.LayoutParams.WRAP_CONTENT;
params.type = WindowManager.LayoutParams.TYPE_APPLICATION;
final WindowManager mWindowManager = (WindowManager);
activity.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            mWindowManager.addView(layout, params);
}
void removeOverlay(){
windowManager.removeView(view);
}