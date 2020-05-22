private String fixLinks(String body) {
    String regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    body = body.replaceAll(regex, "<a href=\"$0\">$0</a>");
    Log.d(TAG, body);
    return body;
}