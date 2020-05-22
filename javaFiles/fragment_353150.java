for (int i=0; i<=diffHour; i++) {
    if (i <= 1) {
        cal.add(Calendar.HOUR, i);
    } else {
        cal.add(Calendar.HOUR, 1);
    }
    String newTime = df.format(cal.getTime());
    System.out.println(newTime);
}