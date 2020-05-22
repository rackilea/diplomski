Intent intent = new Intent(getBaseContext(),
                                some_service.class);
                        PendingIntent pendingIntent = PendingIntent
                                .getService(getBaseContext(), 0, intent, 0);


                        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        // Cancel all previous alarms of the same type
                        alarmManager.cancel(pendingIntent);


                        Calendar calendar = Calendar.getInstance();
                        Calendar currentDate = Calendar.getInstance();

                        calendar.add(Calendar.HOUR, 24);
                        calendar.set(Calendar.HOUR_OF_DAY, 07);
                        calendar.set(Calendar.MINUTE, 00);
                        calendar.set(Calendar.SECOND, 00);

                        // Set alarm manager to run at selected time
                        // each day
                        alarmManager.setRepeating(AlarmManager.RTC,
                                calendar.getTimeInMillis(),
                                AlarmManager.INTERVAL_DAY, pendingIntent);