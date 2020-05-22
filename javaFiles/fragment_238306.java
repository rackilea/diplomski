public class SomePlugin 
{
    static public void onInitialise(final Activity currentActivity) 
    {
        currentActivity.runOnUiThread(new Runnable() {
            Handler someHandler = new Handler(); });
    }
}