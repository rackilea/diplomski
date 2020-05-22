//set new cell D6 having special font settings
  row = CellUtil.getRow(5, sheet);
  cell = CellUtil.getCell(row, 3);
  fontproperties = new HashMap<FontProperty, Object>();
  fontproperties.put(FontProperty.BOLD, true);
  fontproperties.put(FontProperty.COLOR, IndexedColors.BLUE.getIndex());
  fontproperties.put(FontProperty.FONTHEIGHT, (short)(20*20));
  fontproperties.put(FontProperty.FONTNAME, "Courier New");
  fontproperties.put(FontProperty.STRIKEOUT, true);
  fontproperties.put(FontProperty.UNDERLINE, Font.U_DOUBLE);
  font = getFont(wb, getFont(cell), fontproperties);
  styleproperties = new HashMap<String, Object>();
  styleproperties.put(CellUtil.FONT, font.getIndex());
  CellUtil.setCellStyleProperties(cell, styleproperties);
  cell.setCellValue("new cell");