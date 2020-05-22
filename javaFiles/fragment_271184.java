try {
    String input = "Thu, 8 Dec 2016 09:54:00 GMT";
    SimpleDateFormat sdf1 = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
    Date date1 = sdf1.parse(input);
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    String date2 = sdf2.format(date1);
    System.out.println("Parsed : " + date2);  //Parsed : 08-12-2016 09:54:00
} catch (Exception e) {
    System.out.println(e);
}