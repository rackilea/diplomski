CellStyle rightAligned = workbook.createCellStyle();
rightAligned.setAlignment(CellStyle.ALIGN_RIGHT);

Cell richTextCell = row.createCell(0);
RichTextString richTextString = creationHelper.createRichTextString("So rich!");
richTextCell.setCellValue(richTextString);
richTextCell.setCellStyle(rightAligned);

Cell numberCell = row.createCell(1);
numberCell.setCellValue(12.34);
numberCell.setCellStyle(rightAligned);