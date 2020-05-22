Calendar c = Calendar.getInstance();
    c.setTimeZone(TimeZone.getTimeZone("UTC"));
    c.set(1582, Calendar.OCTOBER, 7, 0, 0, 0);
    c.set(Calendar.MILLISECOND, 0);
    d = c.getTime();
    System.out.println("Date: " + d);
    // Prints:
    // Date: Sun Oct 17 00:00:00 GMT 1582