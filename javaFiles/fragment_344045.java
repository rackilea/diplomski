if (DateUtils.isSameDay(date1, date2)) {
    System.out.println("Same Date");
} else if (date1.before(date2)) {
    System.out.println("date1 before date2");
} else {
    System.out.println("date1 after date2");
}