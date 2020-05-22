private Date getDateNearest(List<Date> dates, Date targetDate){
  Date returnDate = targetDate
  for (Date date : dates) {
    // if the current iteration'sdate is "before" the target date
    if (date.compareTo(targetDate) <= 0) {
      // if the current iteration's date is "after" the current return date
      if (date.compareTo(returnDate) > 0){
        returnDate=date;
      }
    }
  }  
  return returnDate;
}