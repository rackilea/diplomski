String fonts[]
        = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

for (int i = 0; i < fonts.length; i++) {
    System.out.println(fonts[i]);
}