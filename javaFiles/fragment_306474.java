try {
    String str_date = "SA-25-MAY";

    // remove SA
    str_date = str_date.replaceFirst("..-", "");

    // add current year
    Calendar c = Calendar.getInstance();
    str_date = c.get(Calendar.YEAR) + "-" + str_date;

    // parse date
    Date date;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MMM");
    date = formatter.parse(str_date);
    System.out.println("Today is " + date);

    // add day
    c.setTime(date);
    c.add(Calendar.DATE, 1);

    // rebuild the old pattern with the new date
    SimpleDateFormat formatter2 = new SimpleDateFormat("EEE-dd-MMM");
    String tomorrow = formatter2.format(c.getTime());
    tomorrow = tomorrow.toUpperCase();
    tomorrow = tomorrow.substring(0, 2) + tomorrow.substring(3);
    System.out.println("Tomorrow is " + tomorrow);
} catch (Exception e) {
    e.printStackTrace();
}