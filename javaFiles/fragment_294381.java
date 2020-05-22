DateFormat dateformat = new SimpleDateFormat("EEE HH:mm:ss");
Date date1 = dateformat.parse(dayTime1);
Date date2 = dateformat.parse(dayTime2);
getDuration(date1, date2, Calendar.MINUTE);

public static long getDuration(Date returnTime, Date leaveTime, int scale) {
        long durationInMillis = returnTime.getTime() - leaveTime.getTime();
        switch (scale) {
            case Calendar.MINUTE:
                return durationInMillis / ONE_MINUTE_IN_MILLIS;
            case Calendar.MILLISECOND:
                return durationInMillis;
            case Calendar.SECOND:
                return durationInMillis / ONE_SECOND_IN_MILLIS;
            case Calendar.HOUR:
                return durationInMillis / ONE_HOUR_IN_MILLIS;
            case Calendar.DAY_OF_YEAR:
            case Calendar.DATE:
                return durationInMillis / ONE_DAY_IN_MILLIS;
        }
        throw new IllegalArgumentException("invalid scale specified");
    }