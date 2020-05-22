private class Scheduler extends Thread {
    @Override
    public void run() {
            Intent i = new Intent(UserLocationUpdaterService.this, UserLocationUpdaterService.this.getClass());
            PendingIntent pendingIntent = PendingIntent.getService(UserLocationUpdaterService.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

            long currentTime = System.currentTimeMillis();

        /* Replace this part with your computation as to when the next trigger should happen. Mine is set to fire off every 5 minutes.*/
            long nextUpdateTimeMillis = currentTime + (5 * DateUtils.MINUTE_IN_MILLIS);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, nextUpdateTimeMillis, pendingIntent);
        }
    }