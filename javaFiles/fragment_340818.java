public String getIntervalAsString(Date date1, Date date2) {
        String format;

        long dT = date2.getTime() - date1.getTime();
        if (dT < 1000 * 60)
            format = "s 'sec'";
        else if (dT < 1000 * 60 * 60)
            format = "m 'min' s 'sec'";
        else if (dT  < 1000 * 60 * 60 * 24)
            format = "h 'hour(s)' m 'min'";
        else if (dT < 1000 * 60 * 60 * 24 * 365)
            format = "d 'day(s)' h 'hour(s)'";
        else
            format = "'more than a year'";

        SimpleDateFormat formatter = new SimpleDateFormat(format);

        return formatter.format(new Date(dT));
    }