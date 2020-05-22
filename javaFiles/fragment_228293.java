Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/CUSTOMFONT-MEDIUM.TTF").openStream());   

GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
genv.registerFont(font);
// makesure to derive the size
font = font.deriveFont(12f);