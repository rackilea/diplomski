public void makeTwoDatesEqual(GregorianCalendar a, GregorianCalendar b) {
    DateTime date1 = new DateTime(a);
    DateTime date2 = new DateTime(b);
    System.out.println("date1=" + date1);
    System.out.println("date2=" + date2);

    Duration duration = new Duration(date1, date2);
    DateTime date3 = date1.plus(duration);
    System.out.println("date3=" + date3);
    System.out.println(date3.equals(date2));
}