Calendar mStart = (Calendar) today.clone();
// set day to 1
mStart.set(Calendar.DAY_OF_MONTH, 1);
// set month to April
mStart.set(Calendar.MONTH, Calendar.APRIL);
// now mStart is April 1st, we can begin the loop

// get the number of days in April
int daysInMonth = today.getActualMaximum(Calendar.DAY_OF_MONTH);
// loop from day 1 to daysInMonth
for (int i = 1; i <= daysInMonth; i++) {
    // set the day
    mStart.set(Calendar.DAY_OF_MONTH, i);
    // add item for the day
    data.add(createItem(mStart.getTimeInMillis()));
}
// add all items to cursor
cursor.addAll(data);