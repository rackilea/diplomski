public static List<String> prepareRangeNumberToCompare2(String text) {
    List<String> result = new ArrayList<>();
    String numberPattern = "-?[\\d+](E-?\\d+)?"; // Pattern for a single number.
    String spacesPattern = "\\s*"; // Pattern for allowing spaces.
    String rangePattern = String.format("(%s)%s-%s(%s)", numberPattern, spacesPattern, spacesPattern,numberPattern); // final pattern is: "(-?[\\d+](E-?\\d+)?)\\s*-\\s*(-?[\\d+](E-?\\d+)?)"

    Pattern pattern = Pattern.compile(rangePattern);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
        result.add(matcher.group(1));
        result.add(matcher.group(3));
    }

    return result;
}