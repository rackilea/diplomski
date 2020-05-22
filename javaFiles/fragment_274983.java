public static void main(String[] args) throws ParseException {
    DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(new Locale("gd", "UK", "scotland"));
    // sorry I don't know the other months in Scottish Gaelic. Thus the numbers
    dateFormatSymbols.setMonths(new String[] { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "an Dàmhair", "11", "12" }); 

    SimpleDateFormat fm = new SimpleDateFormat("yyyy/MMMMM/dd", dateFormatSymbols); 
    System.out.println( fm.parse("2013/an Dàmhair/25"));
}