SimpleDateFormat format = new SimpleDateFormat("hh:mm a EEE", Locale.ENGLISH);
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(format.parse("3:15 AM Tue").getTime());

    Calendar now = Calendar.getInstance();
    Calendar target = Calendar.getInstance();

    if (calendar.get(Calendar.DAY_OF_WEEK) > now.get(Calendar.DAY_OF_WEEK)) {
        target.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        target.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        target.add(Calendar.DATE, calendar.get(Calendar.DAY_OF_WEEK) - now.get(Calendar.DAY_OF_WEEK));
    } else if (calendar.get(Calendar.DAY_OF_WEEK) < now.get(Calendar.DAY_OF_WEEK)) {
        target.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        target.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        target.add(Calendar.DATE, 7 - (now.get(Calendar.DAY_OF_WEEK) - calendar.get(Calendar.DAY_OF_WEEK)));
    } else {
        if (calendar.get(Calendar.HOUR_OF_DAY) > now.get(Calendar.HOUR_OF_DAY)) {
            target.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
            target.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        } else if (calendar.get(Calendar.HOUR_OF_DAY) < now.get(Calendar.HOUR_OF_DAY)) {
            target.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
            target.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
            target.add(Calendar.DATE, 7);
        } else {
            if (calendar.get(Calendar.MINUTE) > now.get(Calendar.MINUTE)) {
                target.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
                target.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
            } else if (calendar.get(Calendar.MINUTE) < now.get(Calendar.MINUTE)) {
                target.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
                target.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
                target.add(Calendar.DATE, 7);
            } else {
                // target time is now!
            }
        }
    }

    long remainingTime = target.getTimeInMillis() - now.getTimeInMillis();
    final long hr = TimeUnit.MILLISECONDS.toHours(remainingTime);
    final long min = TimeUnit.MILLISECONDS.toMinutes(remainingTime - TimeUnit.HOURS.toMillis(hr));
    String result =  String.format("%02d:%02d", hr, min);