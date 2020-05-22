dodaj.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick(View view) {


            if (nazwaLeku.getText().length() > 0 && ileDni.getText().length() > 0) {

                Calendar cal = Calendar.getInstance();
                cal.set(year, month-1, day, hour, minutes, 0);

                Intent intx = new Intent(getApplicationContext(), NotificationReceiver.class);
                intx.PutExtra("Value",YOUR_VALUE_HERE_TO_PASS)

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intx, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

            }
        }
    });