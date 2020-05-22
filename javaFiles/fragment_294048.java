public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String input = "2014-12-09 02:18:38";
    Date date = sdfIn.parse(input);

    System.out.println(sdfOut.format(date));
}