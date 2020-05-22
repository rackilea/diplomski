@ColorInt
public static int parseColor(@Size(min=1) String colorString) {
    if (colorString.charAt(0) == '#') {
        // Use a long to avoid rollovers on #ffXXXXXX
        long color = Long.parseLong(colorString.substring(1), 16);
        if (colorString.length() == 7) {
            // Set the alpha value
            color |= 0x00000000ff000000;
        } else if (colorString.length() != 9) {
            throw new IllegalArgumentException("Unknown color");
        }
        return (int)color;
    } else {
        Integer color = sColorNameMap.get(colorString.toLowerCase(Locale.ROOT));
        if (color != null) {
            return color;
        }
    }
    throw new IllegalArgumentException("Unknown color");
}