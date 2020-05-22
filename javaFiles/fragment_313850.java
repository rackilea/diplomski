Cell cellValue = row.getCell(10, Row.RETURN_NULL_AND_BLANK);
if (cellValue == null)
    List.add("CELL NOT FOUND");
else if("".equals(cellValue.getStringCellValue().trim()))
    List.add("MISSING CONTENT");
else 
    List.add(cellValue.getStringCellValue());