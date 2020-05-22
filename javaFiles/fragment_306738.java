public void onClick(View view) {
    setStatusBarColor();  
} 

public static void setStatusBarColor() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        // If both system bars are black, we can remove these from our layout,
        // removing or shrinking the SurfaceFlinger overlay required for our views.


        //change here
         Window window = activity.getWindow();

        // By -->>>>> Window window = getWindow();

        //or by this if call in Fragment
        // -->>>>> Window window = getActivity().getWindow();


        int statusBarColor = Color.parseColor("#4CAF50");

        if (statusBarColor == Color.BLACK && window.getNavigationBarColor() == Color.BLACK) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        window.setStatusBarColor(statusBarColor);
    }
}