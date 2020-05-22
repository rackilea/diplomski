//method for getting current font from cell
 private static Font getFont(Cell cell) {
  Workbook wb = cell.getRow().getSheet().getWorkbook();
  CellStyle style = cell.getCellStyle();
  return wb.getFontAt(style.getFontIndex());
 }

 private enum FontProperty {
  BOLD, COLOR, FONTHEIGHT, FONTNAME, ITALIC, STRIKEOUT, TYPEOFFSET, UNDERLINE
 }

 //method for getting font having special settings additional to given source font
 private static Font getFont(Workbook wb, Font fontSrc, Map<FontProperty, Object> fontproperties) {
  boolean isBold = fontSrc.getBold();
  short color = fontSrc.getColor();
  short fontHeight = fontSrc.getFontHeight();
  String fontName = fontSrc.getFontName();
  boolean isItalic = fontSrc.getItalic();
  boolean isStrikeout = fontSrc.getStrikeout();
  short typeOffset = fontSrc.getTypeOffset();
  byte underline = fontSrc.getUnderline();

  for (FontProperty property : fontproperties.keySet()) {
   switch (property) {
    case BOLD:
     isBold = (boolean)fontproperties.get(property);
    break;
    case COLOR:
     color = (short)fontproperties.get(property);
    break;
    case FONTHEIGHT:
     fontHeight = (short)fontproperties.get(property);
    break;
    case FONTNAME:
     fontName = (String)fontproperties.get(property);
    break;
    case ITALIC:
     isItalic = (boolean)fontproperties.get(property);
    break;
    case STRIKEOUT:
     isStrikeout = (boolean)fontproperties.get(property);
    break;
    case TYPEOFFSET:
     typeOffset = (short)fontproperties.get(property);
    break;
    case UNDERLINE:
     underline = (byte)fontproperties.get(property);
    break;
   }
  }

  Font font = wb.findFont(isBold, color, fontHeight, fontName, isItalic, isStrikeout, typeOffset, underline);
  if (font == null) {
   font = wb.createFont();
   font.setBold(isBold);
   font.setColor(color);
   font.setFontHeight(fontHeight);
   font.setFontName(fontName);
   font.setItalic(isItalic);
   font.setStrikeout(isStrikeout);
   font.setTypeOffset(typeOffset);
   font.setUnderline(underline);
  }

  return font;
 }