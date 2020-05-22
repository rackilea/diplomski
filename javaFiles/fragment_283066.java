if ((birth_month == month_now) && (birthday == day_now)) {

            Intent intent = new Intent(this, NotificationReceiver.class);
            Intent intent = new Intent(context , DocumentSubFolder.class);
            intent.putExtra("name" , name);
            intent.putExtra("mobile" , mobile);
            intent.putExtra("Dob" , DoB);
            intent.putExtra("image" , byte_image);
            intent.putExtra("position" , position);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 100, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar_now.getTimeInMillis(), pendingIntent);
        }