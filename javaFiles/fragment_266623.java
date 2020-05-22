DateTimeFormatter inputFormatter = DateTimeFormat
    .forPattern("yyyy-MM-dd HH:mm:ss Z")
    .withLocale(Locale.US);

DateTime parsed = inputFormatter.parseDateTime(inputText);

DateTimeFormatter outputFormatter = DateTimeFormat
    .forPattern("HH:mm")
    .withLocale(Locale.US)
    .withZone(DateTimeZone.getDefault());

String outputText = outputFormatter.print(parsed);