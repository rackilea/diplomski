private Font2D getFont2D() {
    // snip
    if (font2DHandle == null) {
        font2DHandle =
            FontManager.findFont2D(name, style,
                                   FontManager.LOGICAL_FALLBACK).handle;
    }
    /* Do not cache the de-referenced font2D. It must be explicitly
     * de-referenced to pick up a valid font in the event that the
     * original one is marked invalid
     */
    return font2DHandle.font2D;
}