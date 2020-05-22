LocalTime start = new LocalTime(13, 46);
LocalTime end = new LocalTime(18, 46);
LocalTime current = start;

for (int i = 0; current.isBefore(end); i++) {
    // code your print action here
    current = current.plusMinutes((i < 2) ? 30 : 60);
}