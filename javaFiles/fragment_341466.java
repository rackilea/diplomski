String time = "2015-01-05T09:20:07.532595Z";
    String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    DateFormat df = new SimpleDateFormat(pattern, Locale.GERMANY);
    Calendar cal = Calendar.getInstance();
    Date date = df.parse(time.substring(0, 23)); // remove the nanoseconds
    cal.setTime(date);

    System.out.println("[ORIGINAL   ] " + time);
    System.out.println("[Result1    ] " + df.format(cal.getTime()));

    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.GERMANY);
    String formatted = format1.format(cal.getTime());
    System.out.println("[formatted  ] " + formatted);
    System.out.println("[parsed     ] " + format1.parse(formatted));