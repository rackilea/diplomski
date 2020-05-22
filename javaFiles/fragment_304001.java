public class MyWidgetIntentReceiver extends BroadcastReceiver {

private static int clickCount = 0;

@Override
public void onReceive(Context context, Intent intent) {
    if(intent.getAction().equals("com.example.intent.action.CHANGE_PICTURE")){
        updateWidgetPictureAndButtonListener(context);
    }
}

private void updateWidgetPictureAndButtonListener(Context context) {
    RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_demo);
    remoteViews.setImageViewResource(R.id.widget_image, getImageToSet());

    //REMEMBER TO ALWAYS REFRESH YOUR BUTTON CLICK LISTENERS!!!
    remoteViews.setOnClickPendingIntent(R.id.widget_button, MyWidgetProvider.buildButtonPendingIntent(context));

    MyWidgetProvider.pushWidgetUpdate(context.getApplicationContext(), remoteViews);
}

private int getImageToSet() {

    clickCount++;
    if (clickCount == 1) {
        return R.drawable.image1 ;
    }
    if (clickCount == 2) {
        return R.drawable.image2 ;
    }
    if (clickCount == 3) {
        return R.drawable.image3 ;
    }
    clickCount = 0;
    return R.drawable.image4 ;
}
}