// first initialize a Calendar item
Calendar currentDate = Calendar.getInstance();
// this is the current date, you can also set up a Calendar with a custom date and time.
// now get the values:
int years = currentDate.get(Calendar.YEAR);
int months = currentDate.get(Calendar.MONTH);
int days = currentDate.get(Calendar.DAY_OF_MONTH);