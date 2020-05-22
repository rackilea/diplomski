Font f = ... ; // you have your font
Character c = 'ن'; // Nun, N, in Farsi

if(!f.canDisplay(c)) {
    int gcode = f.getMissingGlyphCode();
    System.out.format("not supported.  Glyph code used: %d\n", gcode);
}