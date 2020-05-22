SimpleDateFormat sourceDateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");
Date sourceDate = null;
try {
    sourceDate = sourceDateFormat.parse(startDate);
} catch (ParseException e) {
    e.printStackTrace();
}

SimpleDateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
String targetdatevalue= targetFormat.format(sourceDate);