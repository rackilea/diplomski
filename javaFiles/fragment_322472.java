private class ABC extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {

          //here your code

        return returnData;
    }

    @Override
    protected void onPostExecute(String returnedData) {
       //
   String[] parts = returnedData.split(" ");
   ArrayList<String> clientRawData = new ArrayList<String>();
   clientRawData.addAll(Arrays.asList(parts));

   //Time of last update from weather station.
   contentTitle = contentTitle + parts[29] + ":" + parts[30]; 

   Log.e("log_etag", "Content Title " + contentTitle);

   // The Intent to be used when the user clicks on the Notification View
   notificationIntent = new Intent(context, MainActivity.class);

   // The PendingIntent that wraps the underlying Intent
    mContentIntent = PendingIntent.getActivity(context, 0,
        notificationIntent, Intent.FLAG_ACTIVITY_NEW_TASK);

    // Build the Notification
     Notification.Builder notificationBuilder = new Notification.Builder(
        context).setTicker(tickerText)
        .setSmallIcon(android.R.drawable.stat_sys_warning)
        .setAutoCancel(true).setContentTitle(contentTitle)
        .setContentText(contentText).setContentIntent(mContentIntent);


    // Get the NotificationManager
    NotificationManager mNotificationManager = (NotificationManager) context
        .getSystemService(Context.NOTIFICATION_SERVICE);

    // Pass the Notification to the NotificationManager:
    mNotificationManager.notify(MY_NOTIFICATION_ID,
        notificationBuilder.build());

    }


  }
}