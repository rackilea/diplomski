public Font getFont(AttributeSet attr) {
    // PENDING(prinz) add cache behavior
    int style = Font.PLAIN;
    if (StyleConstants.isBold(attr)) {
        style |= Font.BOLD;
    }
    if (StyleConstants.isItalic(attr)) {
        style |= Font.ITALIC;
    }
    String family = StyleConstants.getFontFamily(attr);
    int size = StyleConstants.getFontSize(attr);

    /**
     * if either superscript or subscript is
     * is set, we need to reduce the font size
     * by 2.
     */
    if (StyleConstants.isSuperscript(attr) ||
        StyleConstants.isSubscript(attr)) {
        size -= 2;
    }

    return getFont(family, style, size);
}