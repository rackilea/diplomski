DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
LocalTime lt1 = LocalTime.parse(txtshiftIn, dtf);
LocalTime lt2 = LocalTime.parse(txtshiftOut, dtf);

long diff = ChronoUnit.MINUTES.between(lt1, lt2); //get diff in minutes

if (lt2.isBefore(lt1)) {
  diff += TimeUnit.DAYS.toMinutes(1); //add a day to account for day diff
}

long hours = diff / 60;
long minutes = diff % 60;

LocalTime newTime = LocalTime.parse(String.format("%02d:%02d", hours, minutes), dtf); //Format the difference to be converted to LocalTime

System.out.println(newTime);