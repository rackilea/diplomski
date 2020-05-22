public static String convertToDateString(Date date) {
    String pattern = "YYYY-MM-DD"; 
    //(or another date format, like in dutch: "DD-MM-YYY"
    DateFormat df = new SimpleDateFormat(pattern);
    return df.format(date);
}