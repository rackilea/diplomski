if (networkInfo != null && networkInfo.isConnected()) {
    Log.d("Network is connected. Executing TheTask()", "OK");

    if (flagAlarmSet == true){
       flagAlarmSet = false;
       CancelAlarm(context);
    }

    new TheTask().execute("http://somedomain.tld/index.php?userId=12345678");

}

if (networkInfo == null) {
   Log.d("Network is NOT connected.", "FAIL");
   if (flagAlarmSet == false){
       Log.d("Network is NOT connected.", "Schedule Retry");
       flagAlarmSet = true;
       SetAlarm(context);
   }
   else{
      if (count > 5){
          Log.d("Network is NOT connected.", "Max Tries Reached, Cancel Alarm");
          flagAlarmSet = false;
          CancelAlarm(context);
      }

   }
}