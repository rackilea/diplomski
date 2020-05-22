//Get the window from the context

 WindowManager wm = Context.getSystemService(Context.WINDOW_SERVICE);



   //Unlock

    //http://developer.android.com/reference/android/app/Activity.html#getWindow()
 Window window = getWindow();  

   window.addFlags(wm.LayoutParams.FLAG_DISMISS_KEYGUARD);  



    //Lock device

   DevicePolicyManager mDPM;

  mDPM = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);