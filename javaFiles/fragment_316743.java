public static void main(String[] args) {
    String stringDate  = "Fri Feb 26 14:14:40 CST 2016";
    Date date = convertToDate(stringDate);
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    String dateFormatted = sdf.format(date);
    System.out.println(dateFormatted);
}