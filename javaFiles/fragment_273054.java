String time = "2015-11-10T17:00:00";
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm:ss dd.MM.yyyy");
try {
    Date date = dateFormat.parse(time);

    String out = dateFormat2.format(date);
    Log.e("Time", out);
} catch (ParseException e) {
}