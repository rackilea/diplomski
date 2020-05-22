for (
  PersianCalendar pcal = pInterval.getStart().getTemporal(); 
  pcal.isBefore(pInterval.getEnd().getTemporal(); 
  pcal = pcal.plus(CalendarDays.ONE)
) {
  System.out.println(pcal);
}