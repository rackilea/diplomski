Display display = getWindowManager().getDefaultDisplay();
float width = display.getWidth();
float height = display.getHeight();
if (width>height)
{
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
}
else setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);