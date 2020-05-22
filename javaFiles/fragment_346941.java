public static String dateFormater(String dateFromJSON, String expectedFormat, String oldFormat) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
    Date date = null;
    String convertedDate = null;
    try {
        date = dateFormat.parse(dateFromJSON);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(expectedFormat);
        convertedDate = simpleDateFormat.format(date);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return convertedDate;
}