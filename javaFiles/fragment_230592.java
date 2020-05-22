public String conv(...) {
    try {
        return Timestamp.valueOf(dfAirport2.format(dfAirport1.parse(ts1.toString())));
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    // This line will be executed if a ParseException is thrown within the try block above. We're returning a default timestamp string here because I don't know what your expected behavior is when the given format is invalid.
    return "00:00:00";
}