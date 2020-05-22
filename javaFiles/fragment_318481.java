GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
try (InputStream fontStream = new BufferedInputStream(SwingAppender.class.getResourceAsStream("/com/jsql/view/swing/resources/font/UbuntuMono-Regular-new.ttf"))) {
    Font ubuntuFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
    ge.registerFont(ubuntuFont);
} catch (FontFormatException | IOException e) {
    LOGGER.warn("Loading Font Ubuntu failed", e);
}