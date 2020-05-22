public void setWeekfrom(){
    Calendar cal = Calendar.getInstance();
    Calendar calWeekOnly = Calendar.getInstance();
    calWeekOnly.setTime((Date) dateSpinner.getModel().getValue());
    cal.set(Calendar.WEEK_OF_YEAR, calWeekOnly.get(Calendar.WEEK_OF_YEAR));
    cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
    firstDayofWeek.setValue(cal.getTime());
}