final String keyPattern = "\\S+";
final String valuePattern = "(\\S+|\"[^\"]*\")";
parserMap = Splitter.onPattern("\\s(?=" + keyPattern + "=" + valuePattern + ")")
        .omitEmptyStrings()
        .withKeyValueSeparator(Splitter.onPattern("=(?=" + valuePattern + ")"))
        .split(line);