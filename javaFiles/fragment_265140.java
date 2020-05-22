private static final Pattern DIGIT_OR_LINK_PATTERN =
    Pattern.compile("(\\d|https?:[\\w_/+%?=&.]+)");
// Pattern:          (dig|link                 )

private static final Map<String, String> PERSIAN_DIGITS = new HashMap<>();
static {
   PERSIAN_DIGITS.put("0", "۰");
   PERSIAN_DIGITS.put("1", "۱");
   PERSIAN_DIGITS.put("2", "۲");
   PERSIAN_DIGITS.put("3", "۳");
   PERSIAN_DIGITS.put("4", "۴");
   PERSIAN_DIGITS.put("5", "۵");
   PERSIAN_DIGITS.put("6", "۶");
   PERSIAN_DIGITS.put("7", "۷");
   PERSIAN_DIGITS.put("8", "۸");
   PERSIAN_DIGITS.put("9", "۹");
}

public static String persianDigits(String s) {
    StringBuffer sb = new StringBuffer();
    Matcher m = DIGIT_OR_LINK_PATTERN.matcher(s);
    while (m.find()) {
        String t = m.group(1);
        if (t.length() == 1) {
            // Digit.
            t = PERSIAN_DIGITS.get(t);
        }
        m.appendReplacement(sb, t);
    }
    m.appendTail(sb);
    return sb.toString();
}