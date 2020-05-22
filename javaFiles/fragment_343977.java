try {
    String dateString = "2013-05-07";
    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
    Date date = inputFormat.parse(dateString);
    SimpleDateFormat outputFormat = new SimpleDateFormat("EEEE, dd.MM.yyyy", Locale.US);
    String result = outputFormat.format(date);
} catch (ParseException e) {
    e.printStackTrace();
}