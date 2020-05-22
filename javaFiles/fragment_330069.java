Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 0);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.SECOND, 0);
    Calendar endTime = (Calendar) startOfMonth.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 23);
        endTime.set(Calendar.MINUTE, 59);
        endTime.set(Calendar.SECOND, 59);

    ArrayList<WeekViewEvent> events = new ArrayList<>();
    for (WeekViewEvent event : newEvents) {
            if (event.getEndTime().getTimeInMillis() > startTime.getTimeInMillis() &&
                    event.getStartTime().getTimeInMillis() < endTime.getTimeInMillis())
        {
            events.add(event);
        }
    }