SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
try {
    sdf.setLenient(true);
    Date date = sdf.parse("1/33/1999");
    System.out.println("DateFormat is OK");
    sdf.setLenient(false);
    date = sdf.parse("1/33/1999");

} catch (ParseException ex) {
    ex.printStackTrace();
    if (!sdf.isLenient())  {
        System.out.println("Invalid date");
    } else {
        System.out.println("Invalid date pattern");
    }
}