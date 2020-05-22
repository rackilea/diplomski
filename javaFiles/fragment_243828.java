public static void main(String args[]) {
    Calendar calendar = getISOCalendar();
    calendar.set(2012,0,1);
    System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
}

------
52