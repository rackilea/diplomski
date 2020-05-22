public static Color getColor(int colorCode) {
    for (Color c : Color.values()) {
        if (c.getColorCode() == colorCode)
            return c;
    }
    return NOT_DEFINE;
}