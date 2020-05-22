final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            layoutType,
            0,   // I HAVE CHANGED THIS FROM NOT FOCUS TO ZERO
            PixelFormat.TRANSLUCENT);

params.gravity = Gravity.TOP | Gravity.START;
params.x = 0;   // Initial Position of window
params.y = 100; // Initial Position of window
mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
mWindowManager.addView(mFloatingWidget, params);