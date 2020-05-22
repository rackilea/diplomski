else{
            if (count >= 5){
                Log.d("Network is NOT connected.", "Max Tries Reached, Cancel Alarm");
                count = 0;
                flagAlarmSet = false;
                CancelAlarm(context);
            }