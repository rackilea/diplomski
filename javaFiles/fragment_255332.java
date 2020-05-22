String t1 = "12:03:00";
    String t2 = "00:00:00";
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    Date d1 = sdf.parse(t1);
    Date d2 = sdf.parse(t2);
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c1.setTime(d1);
    c2.setTime(d2);

    if(c2.get(Calendar.HOUR_OF_DAY) < 12) {
        c2.set(Calendar.DAY_OF_YEAR, c2.get(Calendar.DAY_OF_YEAR) + 1);
    }
    long elapsed = c2.getTimeInMillis() - c1.getTimeInMillis();