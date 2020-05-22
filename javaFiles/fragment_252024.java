public boolean isHoliday(Calendar cal) {
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;
    int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

    if (month == 12 && dayOfMonth == 25) {
        return true;
    }

    // more checks

    return false;
}