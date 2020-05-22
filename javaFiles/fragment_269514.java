public Duration timeDifference(String txtshiftIn, String txtshiftOut) {
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
  LocalTime lt1 = LocalTime.parse(txtshiftIn, dtf);
  LocalTime lt2 = LocalTime.parse(txtshiftOut, dtf);

  Duration between = Duration.between(lt1, lt2);

  if (lt2.isBefore(lt1)) { //account for lt2 being on the next day
    between = Duration.ofMinutes(TimeUnit.DAYS.toMinutes(1)).plus(between);
  }

  return between;
}