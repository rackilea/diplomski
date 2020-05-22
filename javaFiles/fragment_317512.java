int from = 2300;
    int to = 800;
    Date date = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    int t = c.get(Calendar.HOUR_OF_DAY) * 100 + c.get(Calendar.MINUTE);
    boolean isBetween = to > from && t >= from && t <= to || to < from && (t >= from || t <= to);