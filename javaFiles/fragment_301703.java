private void getVersion() {
    String source;

    // Try to set a String to the webpages source.
    try {
        source = getUrlSource(url);
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Split the text in half.
    String[] v = source.split("<font color='white'><p>Current Version: ");

    // Gets the part after 'Current Version: '
    String v2 = v[1];

    // Removes the end bit.
    v2 = v2.replace("</font></html>", "");

    // All we have left is '1.0'
    System.out.println(v2);

}