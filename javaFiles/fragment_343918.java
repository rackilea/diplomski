Date date = null;
Date time = null;
// create a SimpleDateFormat instance for your time/date format
SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
try {
    // parse it
    date = format.parse(departureDate);
    // done
} catch (ParseException e) {
    // departureDate could not be parsed, you should handle that case here
}

try {
    // parse it
    time = format.parse(arrivalTime);
    // done
} catch (ParseException e) {
    // arrivalTime could not be parsed, you should handle that case here
}