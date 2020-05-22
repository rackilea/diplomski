String date = "2014-01-01";
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

try {
    Date formattedDate = formatter.parse(date); 
    System.out.println("" + formattedDate);
} catch (ParseException e) {
    System.out.println("" + e);
    e.printStackTrace();
}