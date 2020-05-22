public class BackgroundReceiver extends BroadcastReceiver{
        public static String BROADCAST_ACTION = "your.package.ACTION_BACKGROUND";
        public static String CATEGORY = "your.package.CATEGORY_BACKGROUND";

        @Override
        public void onReceive(Context context, Intent intent){
            Intent downloadIntent = new Intent(context, YourService.class);
            context.startService(downloadIntent);
        }
    }