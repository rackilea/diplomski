} else if (arg instanceof Date) {
    // Note that the following method uses an instance of the
    // default time zone (TimeZone.getDefaultRef().
    cal = Calendar.getInstance(l);
    cal.setTime((Date)arg);
    } else if (arg instanceof Calendar) {
    cal = (Calendar) ((Calendar)arg).clone();
    cal.setLenient(true);
    } else {