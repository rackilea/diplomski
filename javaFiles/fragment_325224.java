DateFormat formatter = new SimpleDateFormat("dd-MMM", Locale.ENGLISH);
try {
    System.out.println(formatter.parse("31-Dec"));
} catch (ParseException e) {
    e.printStackTrace();
}