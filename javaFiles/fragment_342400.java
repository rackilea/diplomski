try{
    font = Font.createFont(Font.TRUETYPE_FONT, new File("myFont.ttf"));
    font = font.deriveFont(30F);
}
catch (Exception ex) {
    ex.printStackTrace();
}