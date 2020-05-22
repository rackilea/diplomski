SimpleDateFormat inputFormat =
    new SimpleDateFormat("kk:mm", Locale.US);
inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

SimpleDateFormat outputFormat =
    new SimpleDateFormat("yyyy/MM/dd kk:mm", Locale.US);
outputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

Date date = inputFormat.parse("12:00");

System.out.println("Time Is: " + outputFormat.format(date));