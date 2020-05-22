HSSFCell hssfCell = row.createCell(idx);
//rich text consists of two runs
HSSFRichTextString richString = new HSSFRichTextString( "Hello, World!" );
richString.applyFont( 0, 6, font1 );
richString.applyFont( 6, 13, font2 );
hssfCell.setCellValue( richString );

XSSFRichTextString s1 = new XSSFRichTextString("Apache POI");
s1.applyFont(boldArial);
cell1.setCellValue(s1);