HttpURLConnection connection = (HttpURLConnection) url.openConnection();

if (connection.getResponseStatus() == 200) {
    // All OK, convert connection.getInputStream() to string.
    // Don't forget to take character encoding into account!
} else {
    // Possible server error. Throw exception yourself? Or return some default?
}