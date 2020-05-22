public static Date parseYearWeek(String yearWeek) {
    DateTime dateTime = DateTimeFormat.forPattern("yy/ww").parseDateTime(yearWeek);

    if (dateTime.getWeekOfWeekyear() == 1 && dateTime.getMonthOfYear() == 12) {
        dateTime = DateTimeFormat.forPattern("yyyy/mm").parseDateTime((dateTime.getYear() + 1) + "/01");
    }

    return dateTime.toDate();
}