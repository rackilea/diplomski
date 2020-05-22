public static void main(String[] args) {
    System.out.println(getNumberOfWeeks(2012, Calendar.JANUARY));
}

static int getNumberOfWeeks(int year, int month) {
    Calendar c = Calendar.getInstance();
    c.set(Calendar.YEAR, year);
    c.set(Calendar.MONTH, month);
    c.set(Calendar.DAY_OF_MONTH, 1);
    int numOfWeeksInMonth = 1;
    while (c.get(Calendar.MONTH) == month) {
        c.add(Calendar.DAY_OF_MONTH, 1);
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            numOfWeeksInMonth++;
        }
    }
    return numOfWeeksInMonth;
}