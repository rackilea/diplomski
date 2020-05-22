public boolean isSpecial(Date date) {
    calendar.setTime(date);
    return calendar.get(Calendar.MONTH) == yourSpecialMonth
    && calendar.get(Calendar.DAY_OF_MONTH) == yourSpecialDay;
}

public Color getSpecialForegroundColor() {
    return yourSpecialForegroundColor;
}

public Color getSpecialBackroundColor() {
    return yourSpecialBackroundColor;
}