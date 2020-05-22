public static List<Date> getBookingDatesInRange(Date startDate, Date endDate, boolean isDaily, boolean isWeekly) {

  List<Date> dates = new ArrayList<>();
  dates.add(startDate);
  Date newDate = startDate;
  while(newDate.before(endDate) || newDate.equals(endDate)) {

    if(isDaily) {
       newDate = Date.valueOf(newDate.toLocalDate().plusDays(1));
    } else if(isWeekly) {
         newDate = Date.valueOf(newDate.toLocalDate().plusWeeks(1));
    } else {
      newDate = Date.valueOf(newDate.toLocalDate().plusMonths(1));
    }
    dates.add(newDate);
    }
  }
  return dates;
}