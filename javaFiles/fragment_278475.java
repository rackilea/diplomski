public static String camelcasify(String in) {
    StringBuilder sb = new StringBuilder();
    boolean capitalizeNext = false;
    for (char c : in.toCharArray()) {
        if (c == '_') {
            capitalizeNext = true;
        } else {
            if (capitalizeNext) {
                sb.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                sb.append(c);
            }
        }
    }
    return sb.toString();
}