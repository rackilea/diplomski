public boolean isValidDate(String inDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
    try {
        dateFormat.parse(inDate);
    }
    catch (ParseException pe) {
        return false;
    }
    return true;
}