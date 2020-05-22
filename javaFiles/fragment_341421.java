public void setBackgroundDrawableForDates(
        Map<Date, Drawable> backgroundForDateMap) {
    if (backgroundForDateMap == null || backgroundForDateMap.size() == 0) {
        return;
    }

    backgroundForDateTimeMap.clear();

    for (Date date : backgroundForDateMap.keySet()) {
        Drawable drawable = backgroundForDateMap.get(date);
        DateTime dateTime = CalendarHelper.convertDateToDateTime(date);
        backgroundForDateTimeMap.put(dateTime, drawable);
    }
}