public Date subtractYear() {
  final Calendar c = new Calendar();
  c.set(year, month, day); // set your class's "current" date
  c.add(Calendar.YEAR, -1); // remove 1 year
  return c.getTime(); // get the Date object back from the Calendar
}