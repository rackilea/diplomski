public static void main(String[] args) throws ParseException {
    BigDecimal bd = new BigDecimal(12051998);
    String s = bd.toString();
    System.out.println(s);
    DateFormat originalFormat = new SimpleDateFormat("MMddyyyy");
    DateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = originalFormat.parse(s);
    String formattedDate = targetFormat.format(date);
    System.out.println(formattedDate);
}