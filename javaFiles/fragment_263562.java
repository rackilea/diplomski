private boolean isValidDate(int year, int month, int day) {
    // Adjust for whatever bounds you want
    if (year < 1900 || year > 2100) {
        System.out.println("Check year");
        return false;
    }

    if (month < 1 || month > 12) {
        System.out.println("Check month");
        return false;
    }

    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(year, month - 1, 1);
    if (day < 1 || day > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
        System.out.println("Check day");
        return false;
    }
    calendar.set(Calendar.DAY_OF_MONTH, day);
    // Store calendar somewhere if you want...
    return true;
}