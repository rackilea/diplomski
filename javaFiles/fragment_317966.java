public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
         if (intent.getAction().equals(Intent.ACTION_SCREEN_ON))
         {
            Intent intent = new Intent();  
            intent.setClass(context, ScreenLockActivity.class);
            startActivity(intent);          
         }
    }
}