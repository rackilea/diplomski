private void doIt3() {
    String line = "GET /something HTTP/1.1 ";
    Pattern pattern = Pattern.compile("GET \\/(.*?) HTTP");
    Matcher m = pattern.matcher(line);

    if (m.find()) {
        System.out.println("Found value => " + m.group(1));
    }
}