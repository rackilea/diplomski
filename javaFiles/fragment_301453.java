public String transformPrevDate(String datoe) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy", Locale.ENGLISH);
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");

    try {
        return dateFormat2.format(dateFormat.parse(datoe));
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}