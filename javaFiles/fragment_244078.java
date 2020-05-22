final Calendar instance = Calendar.getInstance();
    instance.set(Calendar.HOUR, 0);
    instance.set(Calendar.MINUTE, 0);
    instance.set(Calendar.SECOND, 0);
    instance.set(Calendar.MILLISECOND, 0);
    long result = instance.getTimeInMillis() + yourTime;