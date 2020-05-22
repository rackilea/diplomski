private final static String ACTION = "ACTION_ALARM";
     public static void setWakeUpAction(Context context, String hourSet, String minuteSet, String periodSet, int requestCode, String currentAction) {
            try {
                String mHour = hourSet;
                String mMin = minuteSet;
                String[] parsedFormat = null;
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
                SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
                Date date = parseFormat.parse(mHour + ":" + mMin + " " + periodSet);
                parsedFormat = displayFormat.format(date).split(":");
                mHour = parsedFormat[0];
                mMin = parsedFormat[1];
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(mHour));
                calendar.set(Calendar.MINUTE, Integer.parseInt(mMin));
                calendar.set(Calendar.SECOND, 00);
                Intent myIntent = new Intent(context, MyReceiver.class);
                myIntent.putExtra(ACTION, currentAction);
                myIntent.putExtra("Time", new String[]{mHour, mMin, periodSet});
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, requestCode, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }