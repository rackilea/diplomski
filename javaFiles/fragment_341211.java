public static BaseColor decodeColor(String s) {
    if (s == null)
        return null;
    s = s.toLowerCase().trim();
    try {
        return WebColors.getRGBColor(s);
    }
    catch(IllegalArgumentException iae) {
        return null;
    }
}