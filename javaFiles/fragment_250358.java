private static Map<Dimension, Font> mapFonts = new HashMap<>(25);

public static Font getLabelFont() {
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = t.getScreenSize();

    Font font = mapFonts.get(screenSize);
    if (font == null) {

        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        if ((width == 1600.0) && (height == 900.0)
                        || (width == 1440.0) && (height == 900.0)
                        || (width == 1280) && (height == 800)
                        || ((width == 1280) && (height == 768))) {
            font = new Font("Century Gothic", Font.PLAIN, 14);
        } else if ((width == 1024) && (height == 600)) {
            font = new Font("Century Gothic", Font.PLAIN, 12);
        } else if ((width == 1024) && (height == 768)) {
            font = new Font("Century Gothic", Font.PLAIN, 12);
        } else if ((width == 800) && (height == 600)) {
            font = new Font("Century Gothic", Font.PLAIN, 11);
        } else {
            font = new Font("Century Gothic", Font.PLAIN, 11);
        }

        if (font != null) {
            mapFonts.put(screenSize, font);
        }
    }
    return font;
}