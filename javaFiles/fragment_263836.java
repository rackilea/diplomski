HSSFWorkbook hwb = new HSSFWorkbook();
HSSFPalette palette = hwb.getCustomPalette();
// get the color which most closely matches the color you want to use
HSSFColor myColor = palette.findSimilarColor(255, 0, 0);
// get the palette index of that color 
short palIndex = myColor.getIndex();
// code to get the style for the cell goes here
style.setFillForegroundColor(palIndex);