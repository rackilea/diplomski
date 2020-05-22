for (int i = 0; i < dates.size(); i++) {
            TaskItem current = dates.get(i); //dates is the arraylist where I storage all my alarms
            long millis = current.getDateInMillis();

            {
                intent = new Intent(getApplicationContext(), NotificationReceiver.class);
                Bundle b = new Bundle();
                b.putInt("ID", current.getID());
                b.putString("Title", current.getTitle());
                b.putString("Description", current.getDescription());
                b.putInt("Tag", current.getTag());
                b.putInt("NotID", current.getID());
                intent.putExtras(b);


                pi = PendingIntent.getBroadcast(getApplicationContext(), current.getID(), intent, PendingIntent.FLAG_UPDATE_CURRENT);
                manager = (AlarmManager) getSystemService(ALARM_SERVICE);
                manager.setExact(AlarmManager.RTC_WAKEUP, millis, pi);
            }

        }