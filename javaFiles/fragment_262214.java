Pattern FRACTION_PATTERN = Pattern.compile("(?:\\d+\\s+)?\\d/\\d");

    Matcher m = FRACTION_PATTERN.matcher("1/2 + 1 1/2");

    while (m.find()) {
        String found = m.group();
    }