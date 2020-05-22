public class SmsReceiver extends BroadcastReceiver {

    static boolean flagAlarmSet;
    static int count;

    public void onReceive(Context context, Intent intent) {
        final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
        String action = intent.getAction();
        if (action.equals(ACTION_SMS_RECEIVED) || action.equals("ActionRetry")) {

            Log.d("SmsReceiver Broadcast triggered", "OK");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnected()) {
                Log.d("Network is connected. Executing TheTask()", "OK");
                Log.d("connected", "flagAlarmSet to: " + flagAlarmSet);

                //if (flagAlarmSet) { //Removed
                    count = 0;
                    flagAlarmSet = false;
                    CancelAlarm(context);
                    Log.d("Alarm cancelled", "Alarm");
                 //} //Removed

                 //start AsyncTask even if flag was not set, you could have internet the first time in  
                 try {
                        Log.d("SmsReceiver Broadcast triggered", "OK");
                        new TheTask().execute("http://somedomain.tld/index.php?userId=12345678");
                    } catch (Exception e) {
                        Log.d("TheTask Execution Error", "FAIL");
                        e.printStackTrace();
                    }

            }

            if (networkInfo == null) {

                Log.d("Network is NOT connected.", "FAIL");
                if (!flagAlarmSet){
                    Log.d("Network is NOT connected.", "Schedule Retry");
                    flagAlarmSet = true;
                    SetAlarm(context);
                    Log.d("Alarm Set", "Alarm");
                }
                else{
                    count++;
                    if (count >= 5){
                        Log.d("Network is NOT connected.", "Max Tries Reached, Cancel Alarm");
                        count = 0;
                        flagAlarmSet = false;
                        CancelAlarm(context);
                    }
                }
            }
        }
    }

    class TheTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... arg0) {
            String text = null;
            try {

                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(arg0[0]);
                HttpResponse resp = httpclient.execute(httppost);
                HttpEntity ent = resp.getEntity();
                text = EntityUtils.toString(ent);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return text;
        }

        @Override
        protected void onPreExecute() {
            Log.d("Test onPreExecute.", "OK");
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Log.d("Result from server", result);

        }
    }


    public void SetAlarm(Context context)
    {
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, SmsReceiver.class);
        i.setAction("ActionRetry");
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1000 * 60 * 4, 1000 * 60 * 4, pi); // Millisec * Second * Minute
    }


    public void CancelAlarm(Context context)
    {
        Intent intent = new Intent(context, SmsReceiver.class);
        intent.setAction("ActionRetry");
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }
}