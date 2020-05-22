String header = "Estimated\nDuration";
cell.setCellValue(new XSSFRichTextString(header));

// Add this line to turn on wrapped text.
cs.setWrapText(true);

cell.setCellStyle(cs);