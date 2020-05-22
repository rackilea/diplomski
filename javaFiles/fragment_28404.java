private void doSomeAction(Date date) {
  Calendar cal = Calendar.getInstance();
  cal.setTime(date);
  if (cal.get(Calendar.DAY_OF_MONTH) == 1) {
    doSomeActionForFirstDay();
  } else {
    doSomeActionForOtherDays();
  }
}

public void doSomeActionForFirstDay() {
  // IMPLEMENT AND TEST THIS ONE
}

public void doSomeActionForOtherDays() {
  // IMPLEMENT AND TEST THIS ONE
}