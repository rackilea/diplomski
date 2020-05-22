public static Font getPhysicalFont(Font logicalFont) {
    for (int i=0; i<FontManager.getRegisteredFonts().length; i++) {
        Font2D font = FontManager.getRegisteredFonts()[i];
        if (font instanceof CompositeFont && font.getFontName(Locale.getDefault()).equals(logicalFont.getFontName())) {
            PhysicalFont physicalFont = ((CompositeFont) font).getSlotFont(0);
            return new Font(physicalFont.getFamilyName(Locale.getDefault()), physicalFont.getStyle(), logicalFont.getSize());
        }
    }
    return logicalFont;
}