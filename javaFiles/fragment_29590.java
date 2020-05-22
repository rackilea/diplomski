String columnName = null;
    String columnType = null;
    String columnPrecision = null;
    String columnScale = null;
    // Pattern columnTypePattern =
    // Pattern.compile(".*(float|int|char)([0-9]|[1-9][0-9])");
    // field\[(.*)\] = (float|int|char)([0-9]|[1-9][0-9]).*(:(\.([0-9])))
    Pattern columnTypePattern = Pattern
            .compile("field\\[(.*)\\] = (float|int|char)([1-9][0-9]?)?(:\\.([0-9]))?");
    Matcher columnTypeMatcher = columnTypePattern.matcher(line);

    boolean match = columnTypeMatcher.lookingAt();
    System.out.println("Match: " + match);

    if (match) {
        int count = columnTypeMatcher.groupCount();
        if (count > 1) {
            columnName = columnTypeMatcher.group(1);
            columnType = columnTypeMatcher.group(2);
        }
        if (count > 2) {
            columnScale = columnTypeMatcher.group(3);
        }
        if (count > 4) {
            columnPrecision = columnTypeMatcher.group(5);
        }
        System.out.println("Name=" + columnName + "; Type=" + columnType + "; Scale=" + columnScale + "; Precision=" + columnPrecision);
    }