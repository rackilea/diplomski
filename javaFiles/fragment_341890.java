public void hideBars(Activity activity)
{
    //HIDING TOP TITLE TAB
    activity.requestWindowFeature(Window.FEATURE_NO_TITLE);

    //HIDING TOP TOOL BAR
    activity.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

}