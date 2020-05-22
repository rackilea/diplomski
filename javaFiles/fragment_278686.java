char[] buffer = new char[8192];
StringBuilder builder = new StringBuilder();
try (Reader reader = new InputStreamReader(request.getInputStream(), "UTF-8")) {
    int charsRead;
    while ((charsRead = reader.read(buffer)) > 0) {
        builder.append(buffer, 0, charsRead);
    }
}
String text = builder.toString();