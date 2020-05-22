private String convertDateFormat(String date, String oPattern, String ePattern) throws ParseException {
    SimpleDateFormat normalFormat = new SimpleDateFormat(oPattern);
    normalFormat.setLenient(false); /* <-- Add this line -- */
    Date d = normalFormat.parse(date);
    SimpleDateFormat cardFormat = new SimpleDateFormat(ePattern);
    return cardFormat.format(d);
}