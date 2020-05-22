public void drawString(String font, String string, int x, int y, Color color) {

try {
    //You create a new resource stream and load a file
    InputStream inputStream = ResourceLoader.getResourceAsStream(font); // <-- slow

    //You create a new Fonts and load it out of the input stream
    Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream); // <-- extremely slow

    //You create a new TrueTypeFont out of it 
    awtFont = awtFont.deriveFont(24f); // set font size
    font2 = new TrueTypeFont(awtFont, false); // <-- slow

    Color.white.bind();
    font2.drawString(x, y, string, color);
} catch (Exception e) {
    e.printStackTrace();
}
}