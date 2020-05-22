public static int getFontSize(AttributeSet a) {
    Integer size = (Integer) a.getAttribute(FontSize);
    if (size != null) {
        return size.intValue();
    }
    return 12;
}