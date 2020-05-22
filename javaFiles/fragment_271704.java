Calendar userDate = Calendar.getInstance();
Calendar currentDate = Calendar.getInstance();
userDate.setTime(inputDate);//here inputDate is date given by the user.

if(!userDate.before(currentDate)) {
    // user date is after current date(today).
} else {
    // user date is before current date(today).
}