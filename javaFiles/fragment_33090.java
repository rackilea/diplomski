TrueTypeFont font;
TrueTypeFont font2;

public void init() {
    // load a default java font
    Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
    font = new TrueTypeFont(awtFont, false);

    // load font from a .ttf file
    try {
        InputStream inputStream = ResourceLoader.getResourceAsStream("myfont.ttf");

        Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        awtFont2 = awtFont2.deriveFont(24f); // set font size
        font2 = new TrueTypeFont(awtFont2, false);

    } catch (Exception e) {
        e.printStackTrace();
    }   
}