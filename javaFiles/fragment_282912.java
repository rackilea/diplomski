public static void main(String[] args) throws ParseException {
    String d = "02/29/1975";
    DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    sdf.setLenient(false);
    Date date = sdf.parse(d);
    System.out.println(date);
}