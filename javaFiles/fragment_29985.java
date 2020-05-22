if (row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
    System.out.println ("Row No.: " + row.getRowNum ()+ " " +
        row.getCell(0).getNumericCellValue());

    if (HSSFDateUtil.isCellDateFormatted(row.getCell(0))) {
        System.out.println ("Row No.: " + row.getRowNum ()+ " " + 
            row.getCell(0).getDateCellValue());
    }
}