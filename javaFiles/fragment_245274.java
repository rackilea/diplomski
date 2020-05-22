private Font(File fontFile, int fontFormat,
             boolean isCopy, CreatedFontTracker tracker)
    throws FontFormatException {
    this.createdFont = true;
    /* Font2D instances created by this method track their font file
     * so that when the Font2D is GC'd it can also remove the file.
     */
    this.font2DHandle =
        FontManager.createFont2D(fontFile, fontFormat,
                                 isCopy, tracker).handle;
    this.name = this.font2DHandle.font2D.getFontName(Locale.getDefault());
    this.style = Font.PLAIN;
    this.size = 1;
    this.pointSize = 1f;
}