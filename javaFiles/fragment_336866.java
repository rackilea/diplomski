public Shape convert(char c) {
    Font f = getFont();
    // Optionally change font characteristics here
    // f = f.deriveFont(Font.BOLD, 70);

    FontRenderContext frc = getFontMetrics(f).getFontRenderContext();
    GlyphVector v = f.createGlyphVector(frc, new char[] { c });
    return v.getOutline();
}