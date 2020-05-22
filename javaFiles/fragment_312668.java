public static void main(String[] args) {
    String q = "01:00:00";
    String w = "02:00:00";
    String e = "03:00:00";
    String r = "04:00:00";

    LocalTime qq = LocalTime.parse(q);
    LocalTime ww = LocalTime.parse(w);
    LocalTime ee = LocalTime.parse(e);
    LocalTime rr = LocalTime.parse(r);

    List<LocalTime> listTimes = new ArrayList<>();
    listTimes.add(qq);
    listTimes.add(ww);
    listTimes.add(ee);
    listTimes.add(rr);

    // find out what day today is and do that outside the loop
    LocalDate today = LocalDate.now();

    // iterate/stream all the parsed times
    listTimes.forEach(time -> {
        // combine the time with today
        LocalDateTime dateTime = LocalDateTime.of(today, time);
        // then convert it to an Instant (choose the offset you need) and get the millis
        long timeInMillis = dateTime.atZone(ZoneId.systemDefault())
                                .toInstant()
                                .toEpochMilli();

        Intent intent = new Intent(getApplicationContext(), Notification_reciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                                                                100,
                                                                intent,
                                                                PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                                    // use the millis here then
                                    timeInMillis,
                                    AlarmManager.INTERVAL_DAY,
                                    pendingIntent);
    });
}