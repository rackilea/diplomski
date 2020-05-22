private void saveClickTime() {
    sp.edit().putLong("mTime", System.currentTimeMillis()).apply();
}

private boolean isTimeToClick() {
    Date oldDate = new Date(sp.getLong("mTime", System.currentTimeMillis()));
    GregorianCalendar oldCalendar = new GregorianCalendar();
    oldCalendar.setTime(oldDate);
    Calendar newCalendar = new GregorianCalendar();
    return newCalendar.get(Calendar.DATE) != oldCalendar.get(Calendar.DATE) ||
            newCalendar.get(Calendar.MONTH) != oldCalendar.get(Calendar.MONTH) ||
            newCalendar.get(Calendar.YEAR) != oldCalendar.get(Calendar.YEAR);
}