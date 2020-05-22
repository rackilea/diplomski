View myview;

li= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
   wm = (WindowManager) getSystemService(WINDOW_SERVICE);
    WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            //WindowManager.LayoutParams.TYPE_INPUT_METHOD |
            WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,// | WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            PixelFormat.TRANSLUCENT);

     /////////////////////////Another params


WindowManager.LayoutParams params = new WindowManager.LayoutParams(
           WindowManager.LayoutParams.WRAP_CONTENT,
           WindowManager.LayoutParams.WRAP_CONTENT,
           WindowManager.LayoutParams.TYPE_PHONE,
           WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
           PixelFormat.TRANSLUCENT)

    params.gravity = Gravity.RIGHT | Gravity.TOP;
    myview = li.inflate(R.layout.xyz, null); // your layout here    

    wm.addView(myview, params);