public static void main(String args[]) {
    Calendar x = new GregorianCalendar(2014, 10, 10);

    Date date = x.getTime();

    Calendar cal = new GregorianCalendar();
    cal.setTime(date);
    cal.add(Calendar.DAY_OF_MONTH, 25);

    Date newDate = cal.getTime();
    System.out.println(newDate);
}