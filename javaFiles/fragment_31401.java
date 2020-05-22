if (_calendar.get(Calendar.MONTH) == shownMonth.get(Calendar.MONTH)) {
    int day = _calendar.get(Calendar.DAY_OF_MONTH);
    String str = Integer.toString(day);
    drawCell(canvas, row, col, textColor, backgroundColor, str, false);
}
_calendar.add(Calendar.DAY_OF_MONTH, 1);