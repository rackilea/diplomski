String strDate = "2017-05-23T06:25:50";
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
Date convertedDate = new Date();
try {
    convertedDate = dateFormat.parse(strDate);
    SimpleDateFormat sdfnewformat = new SimpleDateFormat("MMM dd yyyy");
    String finalDateString = sdfnewformat.format(convertedDate);
} catch (ParseException e) {
    e.printStackTrace();
}