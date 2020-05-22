InputStream fontStream = Main.class.getResourceAsStream("/fonts/gameFont.ttf");
try {
    Font gameFont = Font.createFont(Font.TRUETYPE_FONT,fontStream);
    gameFont=gameFont.deriveFont(Font.PLAIN, 14);
    displayArea.setFont(gameFont);
} catch (FontFormatException | IOException e) {
    e.printStackTrace();
}