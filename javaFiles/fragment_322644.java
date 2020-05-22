private static final Pattern p = Pattern.compile("([0-9]+)$");

public static int extractNumber(String value) {
    Matcher m = p.matcher(value);
    if(m.find()) {
        return Integer.parseInt(m.group(1));
    } else {
        return Integer.MIN_VALUE; // error code
    }
}