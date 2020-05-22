private Date convertDate(CharSequence input) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

     date = null;
    try {
         String dateString = sdf.format(input);
        date = sdf.parse(dateString);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return date;
}