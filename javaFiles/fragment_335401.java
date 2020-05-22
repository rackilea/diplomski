try {
    SimpleDateFormat  format = new SimpleDateFormat("M d yyyy", Locale.ENGLISH);
    Date date = format.parse(strDate);
    mydate.setTime(date);
} catch (ParseException e) {
    //handle exception
}