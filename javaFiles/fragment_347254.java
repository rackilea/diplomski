public static void main(String[] args) {
    Date date = new Timestamp(1477780200000L);
    System.out.println(date); // 2016-10-30 00:30:00.0
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("CET"));
    calendar.setTime(date);
    print(1, calendar); // 1: Sun Oct 30 00:30:00 CEST 2016 | 1477780200000
    calendar.add(Calendar.HOUR_OF_DAY, 2);
    print(2, calendar); // 2: Sun Oct 30 02:30:00 CEST 2016 | 1477787400000
    calendar.set(Calendar.MINUTE, 0); // minutes expressed in CET
    print(3, calendar); // 3: Sun Oct 30 02:00:00 CET 2016 | 1477789200000

    System.out.println("--");

    calendar = Calendar.getInstance(TimeZone.getTimeZone("CET"));
    calendar.setTime(date);
    print(4, calendar); // 4: Sun Oct 30 00:30:00 CEST 2016 | 1477780200000
    calendar.add(Calendar.HOUR_OF_DAY, 2);
    print(5, calendar); // 5: Sun Oct 30 02:30:00 CEST 2016 | 1477787400000
    calendar.set(Calendar.MINUTE, 0); // minutes expressed in CET
    print(6, calendar); // 6: Sun Oct 30 02:00:00 CET 2016 | 1477789200000

    System.out.println("--");

    calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
    calendar.setTime(date);
    print(4, calendar); // 4: Sun Oct 30 00:30:00 CEST 2016 | 1477780200000
    calendar.add(Calendar.HOUR_OF_DAY, 2);
    print(5, calendar); // 5: Sun Oct 30 02:30:00 CEST 2016 | 1477787400000
    calendar.set(Calendar.MINUTE, 0); // minutes expressed in GMT
    print(6, calendar); // 6: Sun Oct 30 02:00:00 CEST 2016 | 1477785600000
}

private static void print(int prefix, Calendar calendar) {
    System.out.println(prefix + ": " + calendar.getTime() + " | " + calendar.getTimeInMillis());
}